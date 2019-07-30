package rsa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAUtil {

    public static final String SIGN_TYPE_RSA = "RSA";

    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    public static final String CACHED_REQUEST_BODY_OBJECT = "cachedRequestBodyObject";

    private static final Logger log = LoggerFactory.getLogger(RSAUtil.class);

    /**
     * sha1WithRsa 签名
     *
     * @param content
     * @param privateKey
     * @param charset
     * @return
     * @throws Exception
     */
    public static String rsaSign(String content, String privateKey, String charset) throws Exception {
        try {
            PrivateKey priKey = getPrivateKeyFromPKCS8(SIGN_TYPE_RSA,
                    new ByteArrayInputStream(privateKey.getBytes()));

            java.security.Signature signature = java.security.Signature
                    .getInstance(SIGN_ALGORITHMS);

            signature.initSign(priKey);

            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            byte[] signed = signature.sign();

            return new String(Base64.encodeBase64(signed));
        } catch (Exception e) {
            throw new Exception("签名异常", e);
        }
    }


    /**
     * 获取私钥
     *
     * @param algorithm
     * @param ins
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKeyFromPKCS8(String algorithm,
                                                    InputStream ins) throws Exception {
        if (ins == null || StringUtils.isEmpty(algorithm)) {
            return null;
        }
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        byte[] encodedKey = StreamUtil.readText(ins).getBytes();
        encodedKey = Base64.decodeBase64(encodedKey);
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
    }


    /**
     * 获取验签字符串
     *
     * @param body
     * @return
     */
    public static boolean rsaCheck(String body, String publicKey) {
        try {
            log.info("originalBody:{}", body);
            JSONObject jsonObject = JSON.parseObject(body, Feature.OrderedField);
            log.info("jsonObject:{}", jsonObject);
            String signStr = JSON.toJSONString(jsonObject.get("request"), SerializerFeature.WRITE_MAP_NULL_FEATURES, SerializerFeature.QuoteFieldNames);
            String sign = jsonObject.getString("signature");
            String charset = "UTF-8";
            return rsaCheckContent(signStr, sign, publicKey, charset);
        } catch (Exception e) {
            log.info("参数错误", e);
            return false;
        }
    }

    public static boolean rsaCheckContent(String signStr, String sign, String publicKey, String charset) throws Exception {
        try {
            PublicKey pubKey = getPublicKeyFromX509(SIGN_TYPE_RSA,
                    new ByteArrayInputStream(publicKey.getBytes()));

            Signature signature = Signature
                    .getInstance(SIGN_ALGORITHMS);

            signature.initVerify(pubKey);

            log.info("content:" + signStr);
            log.info("sign:" + sign);
            log.info("charset:" + charset);

            if (StringUtils.isEmpty(charset)) {
                signature.update(signStr.getBytes());
            } else {
                signature.update(signStr.getBytes(charset));
            }

            return signature.verify(Base64.decodeBase64(sign.getBytes()));
        } catch (Exception e) {
            log.info("签名错误", e);
            throw new Exception(e);
        }
    }


    /**
     * 获取公钥
     *
     * @param algorithm
     * @param ins
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKeyFromX509(String algorithm,
                                                 InputStream ins) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);

        StringWriter writer = new StringWriter();
        StreamUtil.io(new InputStreamReader(ins), writer);

        byte[] encodedKey = writer.toString().getBytes();

        encodedKey = Base64.decodeBase64(encodedKey);

        return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
    }

}