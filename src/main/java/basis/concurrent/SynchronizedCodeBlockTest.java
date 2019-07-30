package basis.concurrent;

/**
 * 功能:代码块同步
 * 虽然线程1和线程2都进入了对应的方法开始执行，
 * 但是线程2在进入同步块之前，需要等待线程1中同步块执行完成。
 *
 * synchronized 代码块原理：
 * 每个对象有一个监视器锁（monitor）。当monitor被占用时就会处于锁定状态，线程执行monitorenter指令时尝试获取monitor的所有权，过程如下：
 * 1、如果monitor的进入数为0，则该线程进入monitor，然后将进入数设置为1，该线程即为monitor的所有者。
 * 2、如果线程已经占有该monitor，只是重新进入，则进入monitor的进入数加1.
 * 3、如果其他线程已经占用了monitor，则该线程进入阻塞状态，直到monitor的进入数为0，再重新尝试获取monitor的所有权。
 *
 * 执行monitorexit的线程必须是objectref所对应的monitor的所有者。
 * 指令执行时，monitor的进入数减1，如果减1后进入数为0，那线程退出monitor，不再是这个monitor的所有者。
 * 其他被这个monitor阻塞的线程可以尝试去获取这个 monitor 的所有权。
 *
 * 通过这两段描述，我们应该能很清楚的看出Synchronized的实现原理，
 * Synchronized的语义底层是通过一个monitor的对象来完成，
 * 其实wait/notify等方法也依赖于monitor对象，
 * 这就是为什么只有在同步的块或者方法中才能调用wait/notify等方法，
 * 否则会抛出java.lang.IllegalMonitorStateException的异常的原因。
 *
 * @author kmm on 2019-07-30
 */
public class SynchronizedCodeBlockTest {

    public void method1(){
        System.out.println("Method 1 start");

        try {
            synchronized (this){
                System.out.println("Method 1 execute");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Method 1 end");
    }

    public void method2(){
        System.out.println("Method 2 start");

        try {
            synchronized (this){
                System.out.println("Method 2execute");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Method 2 end");
    }

    public static void main(String[] args) {
        final SynchronizedCodeBlockTest test = new SynchronizedCodeBlockTest();

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
