package basis.concurrent;

/**
 * 功能:对普通方法同步
 *  跟代码段一比较，可以很明显的看出，
 *  线程2需要等待线程1的method1执行完成才能开始执行method2方法。
 *
 *  方法的同步并没有通过指令monitorenter和monitorexit来完成（理论上其实也可以通过这两条指令来实现），
 *  不过相对于普通方法，其常量池中多了ACC_SYNCHRONIZED标示符。
 *
 *  JVM就是根据该标示符来实现方法的同步的：
 *  当方法调用时，调用指令将会检查方法的 ACC_SYNCHRONIZED 访问标志是否被设置，如果设置了，
 *  执行线程将先获取monitor，获取成功之后才能执行方法体，方法执行完后再释放monitor。
 *  在方法执行期间，其他任何线程都无法再获得同一个monitor对象。
 *
 *  其实本质上没有区别，只是方法的同步是一种隐式的方式来实现，无需通过字节码来完成。
 * @author kmm on 2019-07-30
 */
public class SynchronizedMethodTest {

    public synchronized void method1(){
        System.out.println("Methdo 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    public synchronized void method2(){
        System.out.println("Methdo 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }

    public static void main(String[] args) {
        final SynchronizedMethodTest test = new SynchronizedMethodTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method2();
            }
        }).start();


    }
}
