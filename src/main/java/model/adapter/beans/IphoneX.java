package model.adapter.beans;

import lombok.Data;
import model.adapter.service.LightningInterface;

/**
 * 功能:苹果手机
 *
 * @author kmm on 2019-07-08
 */
@Data
public class IphoneX {

    private LightningInterface lightningInterface;

    public void charge(){
        System.out.println("开始给我的Iphonese手机充电...");
        lightningInterface.chargeWithLightning();
        System.out.println("结束给我的Iphonese手机充电...");

    }
}
