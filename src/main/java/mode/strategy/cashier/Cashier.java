package mode.strategy.cashier;

import mode.strategy.impl.Buyer;

import java.math.BigDecimal;

/**
 * 功能：定义上下文类，所谓上下文类，就是集成算法的类。这个例子中就是收银台系统
 *
 * @author kmm on 2019/5/17
 */
public class Cashier {

    /**
     * 会员,策略对象
     */
    private Buyer buyer;

    public Cashier(Buyer buyer){
        this.buyer = buyer;
    }

    public BigDecimal quote(BigDecimal orderPrice) {
        return buyer.calPrice(orderPrice);
    }


}
