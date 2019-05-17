package mode.strategy;

import mode.strategy.impl.Buyer;

import java.math.BigDecimal;

/**
 * 功能：超级会员
 *
 * @author kmm on 2019/5/17
 */
public class SuperVipBuyer implements Buyer {
    /**
     * 计算应付价格
     *
     * @param orderPrice
     */
    public BigDecimal calPrice(BigDecimal orderPrice) {
        return orderPrice.multiply(new BigDecimal(0.8));
    }
}
