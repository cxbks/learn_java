package basis.concurrent;

/**
 * 功能:没有同步的情况
 *  线程1和线程2同时进入执行状态，线程2执行速度比线程1快，
 *  所以线程2先执行完成，这个过程中线程1和线程2是同时执行的。
 * @author kmm on 2019-07-30
 */
public class NoSynchronizedTest {
    public void method1(){
        System.out.println("Methdo 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    public void method2(){
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
        final NoSynchronizedTest test = new NoSynchronizedTest();

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
