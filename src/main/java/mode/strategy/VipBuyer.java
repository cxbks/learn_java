package mode.strategy;

import mode.strategy.impl.Buyer;

import java.math.BigDecimal;

/**
 * 功能：普通会员
 *
 * @author kmm on 2019/5/17
 */
public class VipBuyer implements Buyer {
    /**
     * 计算应付价格
     *
     * @param orderPrice
     */
    public BigDecimal calPrice(BigDecimal orderPrice) {
        int  superVipExpiredDays  = 1;
//        int superVipLeadDiscountTimes  = 2;
        if(superVipExpiredDays < 7){

            return orderPrice.multiply(new BigDecimal(0.8));
        }
        return orderPrice.multiply(new BigDecimal(0.9));
    }
}
