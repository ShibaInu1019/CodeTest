package JVM;

import java.util.HashSet;
import java.util.Set;

/**
 * -XX:PermSize=6M
 * -XX:MaxPermSize=6M
 */
public class FinalPoolOOM {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        short i = 0;
        while (true){
            set.add(String.valueOf(i++).intern());
        }
    }
}
