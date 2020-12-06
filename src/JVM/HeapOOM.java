package JVM;

import java.util.LinkedList;
import java.util.List;

/**
 * 堆OOM
 * -Xms20M
 * -Xmx20M
 * -XX:+HeapDumpOnOutOfMemoryError
 *
 * Java heap space
 */
public class HeapOOM {
    static class OOMObject {
    }
    public static void main(String[] args) {
        List<OOMObject> list = new LinkedList<OOMObject>();
        while (true)
            list.add(new OOMObject());
    }
}
