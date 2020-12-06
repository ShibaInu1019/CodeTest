package JVM;

/**
 * -Xss128k
 */
public class StackOOM {
    private int length = 1;
    public void recur() {
        length++;
        recur();
    }
    public static void main(String[] args) {
        StackOOM stackOOM = new StackOOM();
        try {
            stackOOM.recur();
        } catch (Throwable e) {
            System.out.println("stack length:"+stackOOM.length);
            throw e;
        }
    }
}
