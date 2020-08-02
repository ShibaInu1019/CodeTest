package Thread.Final;

import java.util.HashSet;
import java.util.Set;

/**
 * 不可变对象
 */
public class FinalDemo {
    private final Set<String> set = new HashSet<>();

    public FinalDemo() {
        set.add("不可变");
    }

    public boolean isContains(String str) {
        return set.contains(str);
    }
}
