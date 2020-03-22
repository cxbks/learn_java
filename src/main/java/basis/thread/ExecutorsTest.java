package basis.thread;

/**
 * 功能:线程池
 *
 * @author kmm on 2020/3/19
 */
public class ExecutorsTest {

    public static void main(String[] args) {
        int corePoolSiza = getCorePoolSize();
        System.out.println(corePoolSiza);

    }

    /**
     * 获取当前运行的系统可活跃的线程数
     * @return
     */
    public static int getCorePoolSize(){
        return Runtime.getRuntime().availableProcessors();
    }
}
