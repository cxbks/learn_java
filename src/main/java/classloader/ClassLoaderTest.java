package classloader;

/**
 * 功能:类加载器的测试
 *
 * @author kmm on 2020/3/16
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {
        // testClassLoaderParent();

        String rootDir = "/Users/macpro/IdeaProjects/git/learn_java/src/main/java/";
        FileClassLoader fileClassLoader1 = new FileClassLoader(rootDir);
        FileClassLoader fileClassLoader2 = new FileClassLoader(rootDir);
        Class<?> object1 = fileClassLoader1.findClass("classloader.DemoObj");
        Class<?> object2 = fileClassLoader2.findClass("ClassLoaderTest");
        System.out.println("findClass->obj1:"+object1.hashCode());
        System.out.println("findClass->obj2:"+object2.hashCode());


    }

    /**
     * 输出各加载器的父类
     */
    private static void testClassLoaderParent() {
        String rootDir = "/";
        FileClassLoader fileClassLoader = new FileClassLoader(rootDir);

        System.out.println("自定义类加载器的父加载器: " + fileClassLoader.getParent());
        System.out.println("系统默认的AppClassLoader: " + ClassLoader.getSystemClassLoader());
        System.out.println("AppClassLoader的父类加载器: " + ClassLoader.getSystemClassLoader().getParent());
        System.out.println("ExtClassLoader的父类加载器: " + ClassLoader.getSystemClassLoader().getParent().getParent());

        /**
         输出结果:
         自定义类加载器的父加载器: sun.misc.Launcher$AppClassLoader@29453f44
         系统默认的AppClassLoader: sun.misc.Launcher$AppClassLoader@29453f44
         AppClassLoader的父类加载器: sun.misc.Launcher$ExtClassLoader@6f94fa3e
         ExtClassLoader的父类加载器: null
         */
    }
}
