package basis.concurrent;

/**
 * 功能:静态方法(类)同步
 * 对静态方法的同步本质上是对类的同步（静态方法本质上是属于类的方法，而不是对象上的方法），
 * 所以即使test和test2属于不同的对象，
 * 但是它们都属于SynchronizedTest类的实例，所以也只能顺序的执行method1和method2，不能并发执行。
 * @author kmm on 2019-07-30
 */
public class SynchronizedStaticMethodTest {
    public static synchronized void method1(){
        System.out.println("Method 1 start");

        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Method 1 end");
    }


    public static synchronized void method2(){
        System.out.println("Method 2 start");

        try {
            System.out.println("Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Method 2 end");
    }

    public static void main(String[] args) {
        final SynchronizedStaticMethodTest test1 = new SynchronizedStaticMethodTest();
        final SynchronizedStaticMethodTest test2 = new SynchronizedStaticMethodTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.method2();
            }
        }).start();
    }
}
