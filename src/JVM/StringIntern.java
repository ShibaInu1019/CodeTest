package JVM;

/**
 * intern方法会把首次遇到的字符串实例复制到永久代的运行时常量池中去，
 * 返回的也是运行时常量池这个字符串的引用；
 * <p>
 * （JDK6运行时常量池在方法区中，JDK6+常量池在堆中）
 */


public class StringIntern {

    public static void main(String[] args) {
        //java不是第一次出现的字符串
        String builder1 = new StringBuilder("ja").append("va").toString();
        System.out.println(builder1.intern() == builder1);//false

        // aabb是首次出现的字符串，常量池中没有aabb的引用，那么记录一下aabb出现的引用，
        // Stringbuilder创建的实例和常量池中的aabb是同一个字符串
        String builder2 = new StringBuilder("aa").append("bb").toString();
        System.out.println(builder2.intern() == builder2);//true
    }
}
