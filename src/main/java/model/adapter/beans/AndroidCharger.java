package model.adapter.beans;

import model.adapter.service.TypeCInterface;

/**
 * 功能:安卓设备的充电器
 *
 * @author kmm on 2019-07-08
 */
public class AndroidCharger implements TypeCInterface {


    @Override
    public void chargeWithTypeC() {
        System.out.println("使用Type-C型号的充电器充电...");

    }
}
