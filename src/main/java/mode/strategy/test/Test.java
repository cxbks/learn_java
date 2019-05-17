package mode.strategy.test;

import mode.strategy.SuperVipBuyer;
import mode.strategy.cashier.Cashier;
import mode.strategy.impl.Buyer;

import java.math.BigDecimal;

/**
 * 功能：
 *
 * @author kmm on 2019/5/17
 */
public class Test {

    public static void main(String[] args) {

        //选择并创建需要使用的策略对象
        Buyer strategy = new SuperVipBuyer();
        //创建上下文
        Cashier cashier = new Cashier(strategy);
        BigDecimal bigDecimal = new BigDecimal(300);
        //计算价格
        BigDecimal quote = cashier.quote(bigDecimal);
        System.out.println("普通会员商品的最终价格为：" + quote.doubleValue());

        strategy = new SuperVipBuyer();
        cashier = new Cashier(strategy);
        quote = cashier.quote(bigDecimal);
        System.out.println("超级会员商品的最终价格为：" + quote.doubleValue());
    }
}
