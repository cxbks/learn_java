package model.adapter;

import lombok.Data;
import model.adapter.service.LightningInterface;
import model.adapter.service.TypeCInterface;

/**
 * 功能:Lightning 充电适配器
 *
 * @author kmm on 2019-07-08
 */
@Data
public class Adapter implements LightningInterface {
    private TypeCInterface typeCInterface;


    public Adapter(TypeCInterface typeCInterface) {
        this.typeCInterface = typeCInterface;
    }

    @Override
    public void chargeWithLightning() {
        typeCInterface.chargeWithTypeC();
    }
}
