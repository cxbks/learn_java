package rsa;

import com.alibaba.fastjson.JSON;
import rsa.data.TemplateData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能：
 *
 * @author kmm on 2019/6/3
 */
public class RSAUtilTest {

    public static void main(String[] args) {

        Map<String, Object> request = new LinkedHashMap<>(4);
        Map<String, Object> head = new LinkedHashMap<>(1);

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+HH:mm");
        String str = df.format(date);
        System.out.println(str);

        head.put("version", "2.0.0");
        head.put("appid", "test001");
        head.put("request_time", str);
        head.put("reserve", "{}");
        request.put("head", head);

        Map<String, Object> body = new LinkedHashMap<>(7);

        //region 图文消息
//        request.put("body", getnews(body));
        //endregion

        //region 文本消息
//        request.put("body", getText(body));
//        //endregion

        //region 模板消息
//        request.put("body", getTemplate(body));
        //endregion

        //region 小程序消息
        request.put("body", getMiniprogrampage(body));
        //endregion


        String content = JSON.toJSONString(request);
        String sign = null;
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCeT0oUFYw3yMc+Si/NVo8CmjpyDOI8OJfbu6Bt2DAfyf3mhATAa/rtEXHeuhsoz42rLyoPnhdvpknLL4QtlEsCVsyIH34sEgVPl4OyPyFojxTDMNGrVHzuk90LpiZ9+CpUGwSpiLc94HtT3nkTIQ28fER7wrgMyP1lk+rofunj83Bq/jw2RQ54A4f+x6jntcvzkRNRRnJntaGaTMv33NIUDncTt4q33odqBKBxBSvzbYxKMdDNopyaXnPiAhOWz798EKbYpaAoUjKXg3ivEunGl9mlc2KSmYpV5EhI7eYZIhnsxpJfZWLETQ1tXAaI29JaiYqNQNoQYKkkSa+ZPkKfAgMBAAECggEBAJoJXHMeZEkDO5sIZGrQBmbp2mSO1LLz/g74CanX6TuFN1/MpTL13jo99yZYv4R+L8KZKbv4f6VLkBH8MgiHelTUUD9DJWmMP06qhqIxezhZwEIMhnbGxqj9ht+G031OsyETCP5M4L98ZYO9vOE4ED2OTLR/SsZl6umje7athrcc5/x7QWRGLlnb5pYVTyPyxe5NFzI24rRQAZCv0z20WU6MzzZOxeBG0dpGwPAP3QyPdTV7BTrjU/SGxiE4Qigv2GTetNjf533liFzHc54FLOcI2Bu4+8XnQupwXkxJHYCCUrleE6EARkFfh4/caE44cpVzu/KrBpMlIe2OaTQREMECgYEA0V3M/X/PeC6ZOD8llRJu4lOXEtEvARGdbSerSYon0K2K79qz7WaqMXLbo4fcdcpTxI+dalPeSwCHqRtuqxTFxZSBf61IT2njMzjrPzYq/h47J0+sxmj73M4GNNaOk3cmgp9a/GCN/8pFBclg7eQjwZKb39/q9I1mYMJGlsgGRvMCgYEAwZI0oDAeOEgnWNRdXAaZow+Rqm5e+nXpOiEtleaova/4uuKxed1PPaYgwNNhgUd2+ZX3TtirLR4E7sc5gDVFzodHG+XxHRwIZH6t/3K0TDcAC0+zkSauYAboKFX72d5UimB2SvFu4f2StG3puHnv2TpdruQIrwR0yVoDhPm1WKUCgYAUekI0gS2/qX8e+z4nyHfD9z0NgBxC1IA7Tuf392VRicfPEesLS0FWOM+2vPEZLELpNMrGvZE+cLzUE3TNkuiNHKtV25L5AXhRaD3KHvgxhq9uduKFPXt060m8HUgwsDS6DfAOQztgS15Y5ItweSHuKvLIANSwOqxKxnW1BbdndQKBgGzOJ/Ka2YG9XRCbXlbqBtYXXEO2goC6YnygRaVq4BKvpVo3LpdXhMEcbnC04KvwZbnpR/fz5lQX+aHWLkYYq8JpW9kcqSk5pqYGZvudmCb3C3lQNZkzavTjLP/vRP+z70VQ7200xKUXCa2N0sA1GlK6cgpqd08ZbCP6CtxmGD9ZAoGASkFSLaf29iKMCt89OqTEzttYOFf/zVUVGoncBxhDnz6hvrYTM4i4ap3IMgQ8a1CHrhx2hBn62MCy61oHw0B26j2O5zaOw6HWh9XVXENplI2mGftqzzXZiZByt97u0fFVVVYIuH7Lztw5BT+wWmHuJxV++PHTFy4UzEHQEPQw4rs=";
        System.out.println(content);
        try {
            sign = RSAUtil.rsaSign(content, privateKey, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(sign);
    }


    /**
     * 获取小程序消息
     * @param body
     */
    private static Map getMiniprogrampage(Map<String, Object> body) {
        body.put("appId", "wxe329bd05e5dcd794");
        body.put("touser", "o24xJs2vnyIZlGzTepq2nFngRJjc");
        body.put("msgtype","miniprogrampage");
        body.put("title", "推送小程序");
        body.put("miniAppId", "wxef8c91f21d4c40b9");
        body.put("pagepath", "");
        body.put("thumbMediaId", "HNgU4F23dOlrGbR72EZhHy1NW9hvITNAK32r83tf-0c");
        return body;
    }

    /**
     * 获取模板消息
     * @param body
     */
    private static Map getTemplate(Map<String, Object> body) {
        body.put("appId", "wxe329bd05e5dcd794");
        body.put("touser", "o24xJs2vnyIZlGzTepq2nFngRJjc");
        body.put("templateId", "mG7PrKRYw3GeAhY3aoRtlZx1adn8987frG1QPKr1-_s");
        body.put("url", "http://www.qq.com");

        List<Object> templateDataList = new ArrayList<>(4);

        TemplateData templateData = new TemplateData();
        templateData.setDataKey("first");
        TemplateData.DataValue dataValue = new TemplateData.DataValue();
        dataValue.setValue("测试");
        dataValue.setColor("");
        templateData.setDataValue(dataValue);


        TemplateData templateData1 = new TemplateData();
        templateData1.setDataKey("keyword1");
        TemplateData.DataValue dataValue1 = new TemplateData.DataValue();
        dataValue1.setValue("keyword1");
        dataValue1.setColor("");
        templateData1.setDataValue(dataValue1);

        TemplateData templateData2 = new TemplateData();
        templateData2.setDataKey("keyword2");
        TemplateData.DataValue dataValue2 = new TemplateData.DataValue();
        dataValue2.setValue("keyword2");
        dataValue2.setColor("");
        templateData2.setDataValue(dataValue2);

        TemplateData templateData3 = new TemplateData();
        templateData3.setDataKey("keyword3");
        TemplateData.DataValue dataValue3 = new TemplateData.DataValue();
        dataValue3.setValue("keyword3");
        dataValue3.setColor("");
        templateData3.setDataValue(dataValue3);

        TemplateData templateData4 = new TemplateData();
        templateData4.setDataKey("keyword4");
        TemplateData.DataValue dataValue4 = new TemplateData.DataValue();
        dataValue4.setValue("keyword4");
        dataValue4.setColor("");
        templateData4.setDataValue(dataValue4);

        TemplateData templateData5 = new TemplateData();
        templateData5.setDataKey("keyword5");
        TemplateData.DataValue dataValue5 = new TemplateData.DataValue();
        dataValue5.setValue("keyword5");
        dataValue5.setColor("");
        templateData5.setDataValue(dataValue5);

        TemplateData templateData6 = new TemplateData();
        templateData6.setDataKey("remark");
        TemplateData.DataValue dataValue6 = new TemplateData.DataValue();
        dataValue6.setValue("remark");
        dataValue6.setColor("");
        templateData6.setDataValue(dataValue6);

        templateDataList.add(templateData);
        templateDataList.add(templateData1);
        templateDataList.add(templateData2);
        templateDataList.add(templateData3);
        templateDataList.add(templateData4);
        templateDataList.add(templateData5);
        templateDataList.add(templateData6);

        body.put("templateDataList", templateDataList);
        return body;
    }

    /**
     * 获取文本消息
     * @param body
     */
    private static Map getText(Map<String, Object> body) {
        body.put("appId", "wxe329bd05e5dcd794");
        body.put("touser", "o24xJs2vnyIZlGzTepq2nFngRJjc");
        body.put("msgtype", "text");
        body.put("content", "hello");
        return body;
    }

    /**
     * 获取图文消息
     * @param body
     * @return
     */
    private static Map getnews(Map<String, Object> body) {
        body.put("appId", "wxe329bd05e5dcd794");
        body.put("touser", "o24xJs2vnyIZlGzTepq2nFngRJjc");
        body.put("msgtype", "news");
        body.put("title", "尊敬的顾客，您已支付成功!");
        body.put("description", "尊敬的客服 姓名：aaa性别：男 消费金额：99.00元 交易订单号：2010101001");
        body.put("url", "https://www.baidu.com");
        body.put("picurl", "https://images.wosaimg.com/54/e2d5fc676ff109ae512f92d3bee1b0");
        return body;
    }
}


