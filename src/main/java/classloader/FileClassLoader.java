package classloader;

/**
 * 功能:
 *
 * @author kmm on 2020/3/16
 */
public class FileClassLoader extends ClassLoader {

    private String rootDir;

    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    /**
     * 编写获取类的字节码并创建class对象的逻辑
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //省略逻辑代码
        return super.findClass(name);
    }

    private byte[] getClassData(String className) {
        //读取类文件的字节
        return null;

    }


}
