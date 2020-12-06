package CCC;

public class Singleton {

    private Singleton() {
    }

    private static volatile Singleton singleton;

    public Singleton getInstance() {
        if (singleton != null) {
            synchronized (Singleton.class) {
                if (singleton != null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
