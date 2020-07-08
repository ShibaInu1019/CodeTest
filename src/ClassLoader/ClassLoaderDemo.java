package ClassLoader;

public class ClassLoaderDemo {

    public static void main(String[] args) {
        Class c = ClassLoaderDemo.class;

        //由于是使用系统类加载器（非自定义加载器）来加载ClassLoaderDemo类，应该输出AppClassLoader
        System.out.println(c.getClassLoader());
        //AppClassLoader的父加载器应该是ExtClassLoader
        System.out.println(c.getClassLoader().getParent());
        //ExtClassLoader的父加载器应该是BootStrapClassLoader（BootStrapClassLoader应该输出null）
        System.out.println(c.getClassLoader().getParent().getParent());

    }
}
