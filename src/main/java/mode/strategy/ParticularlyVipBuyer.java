package mode.strategy;

import mode.strategy.impl.Buyer;

import java.math.BigDecimal;

/**
 * 功能：专属会员
 *
 * @author kmm on 2019/5/17
 */
public class ParticularlyVipBuyer implements Buyer {

    public BigDecimal calPrice(BigDecimal orderPrice) {
        if (orderPrice.compareTo(new BigDecimal(30)) > 0) {
            return orderPrice.multiply(new BigDecimal(0.7));
        }
        return orderPrice;
    }

}
