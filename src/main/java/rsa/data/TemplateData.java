package rsa.data;

import lombok.Data;

/**
 * 功能：模板中的动态数据
 *
 * @author kmm on 2019/5/24
 */
@Data
public class TemplateData {

    /**
     * 模板占位符编号 如{{first.DATA}}则 dataKey 为 first
     */
    private String dataKey;

    /**
     * 模板内容
     */
    private DataValue dataValue;

    @Data
    public static class DataValue {

        /**
         * 模板内容
         */
        private String value;

        /**
         * 模板内容字体颜色，不填默认黑色
         */
        private String color;
    }

}
