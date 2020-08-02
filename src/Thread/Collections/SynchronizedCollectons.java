package Thread.Collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynchronizedCollectons {


    List<Integer> list = Collections.synchronizedList(new ArrayList<>());

    Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());

    Collection<Object> List = Collections.synchronizedCollection(new LinkedList());

    Vector vector = new Vector();


    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
}
