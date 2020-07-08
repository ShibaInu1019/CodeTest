package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        //获取ReflectDemo类
        Class rd = ReflectDemo.class;
        //实例化ReflectDemo，默认会调用public无参构造器
        ReflectDemo reflectDemo = (ReflectDemo) rd.newInstance();

        //获得private有参构造器，传入参数类型
        Constructor constructor = rd.getDeclaredConstructor(java.lang.String.class);
        //设置权限（可以访问private）
        constructor.setAccessible(true);
        //使用private有参构造器实例化对象，调用private有参构造器
        reflectDemo = (ReflectDemo) constructor.newInstance("welcome");

        //获得public有参方法，传入方法名say以及参数类型String
        Method methodPublic = rd.getDeclaredMethod("say", java.lang.String.class);
        //调用say方法，传入reflectDemo对象以及参数值
        methodPublic.invoke(reflectDemo, "hello");

        //获得private无参方法，传入方法名hi
        Method methodPrivate = rd.getDeclaredMethod("hi");
        //设置权限（可以访问private）
        methodPrivate.setAccessible(true);
        //调用hi方法，传入reflectDemo对象
        String strnull = (String) methodPrivate.invoke(reflectDemo);
        //由于ReflectDemo类中res属性未赋值，所以会输出null
        System.out.println(strnull);

        //获取private属性res，传入属性名res
        Field field = rd.getDeclaredField("res");
        //设置权限（可以访问private）
        field.setAccessible(true);
        //设置res属性值
        field.set(reflectDemo, "world");
        //调用hi方法，传入reflectDemo对象
        String str = (String) methodPrivate.invoke(reflectDemo);
        //此时res属性已赋值
        System.out.println(str);
    }
}
