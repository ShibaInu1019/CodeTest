package Reflect;


public class ReflectDemo {

    private String res;

    public ReflectDemo() {
        System.out.println("public无参构造方法");
    }

    private ReflectDemo(String str) {
        System.out.println("private有参构造方法：" + str);
    }

    public void say(String name) {
        System.out.println("public有参方法：" + name);
    }

    private String hi() {
        return "private无参方法：" + res;
    }
}
