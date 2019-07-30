package model.adapter;

import model.adapter.beans.AndroidCharger;
import model.adapter.beans.IphoneX;

/**
 * 功能:测试使用Lightning 充电的适配器给苹果手机充电
 *
 * @author kmm on 2019-07-08
 */
public class Test {
    public static void main(String[] args) {
        Adapter adapter = new Adapter(new AndroidCharger());
        IphoneX iphoneX = new IphoneX();
        iphoneX.setLightningInterface(adapter);
        iphoneX.charge();

    }
}
