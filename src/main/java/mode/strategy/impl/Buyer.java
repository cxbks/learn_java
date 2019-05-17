package mode.strategy.impl;

import java.math.BigDecimal;

/**
 * 功能：定义一个接口，这个接口就是抽象策略类，该接口定义了计算价格方法，具体实现方式由具体的策略类来定义。
 *
 * @author kmm on 2019/5/17
 */
public interface Buyer {

    /**
     * 计算应付价格
     */
    public BigDecimal calPrice(BigDecimal orderPrice);
}
