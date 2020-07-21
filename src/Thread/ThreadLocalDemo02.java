package Thread;

import javax.sound.midi.Soundbank;

/**
 * ThreadLocal避免传递参数麻烦
 */
public class ThreadLocalDemo02 {
    public static void main(String[] args) {
        new Service01().process();
    }

}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}

class ThreadLocalHolder {
    public static ThreadLocal<User> threadLocal = new ThreadLocal<>();
}

class Service01 {
    public void process() {
        User user = new User("休斯顿");
        ThreadLocalHolder.threadLocal.set(user);
        new Service02().process();
    }

}

class Service02 {
    public void process() {
        User user = ThreadLocalHolder.threadLocal.get();
        System.out.println(user.name);
        new Service03().process();
    }

}

class Service03 {
    public void process() {
        User user = ThreadLocalHolder.threadLocal.get();
        System.out.println(user.name);
    }

}

