import java.util.*;

/**
 * Remove Least Recently used (LRU) element
 * 1. Get any element
 * 2. Remove that element form that position
 * 3. put that element in Front
 * 4. If try to add new element then Store in front and remove element from the end
 * <p>
 * We can not use Queue as requested element can be in middle.
 */

class LRUCacheImpl3 {
    private Set<Integer> cache;
    private int capacity;

    public LRUCacheImpl3(int capacity) {
        this.cache = new LinkedHashSet<>(capacity);
        this.capacity = capacity;
    }

    public boolean get(int key) {
        if (!cache.contains(key))
            return false;
        cache.remove(key);
        cache.add(key);
        return true;
    }

    public void refer(int key) {
        if (get(key) == false)
            put(key);
    }

    public void put(int key) {
        if (cache.size() == capacity) {
            int firstKey = cache.iterator().next();
            cache.remove(firstKey);
        }
        cache.add(key);
    }

    @Override
    public String toString() {
        return "LRUCacheImpl{" +
                "dataStorage=" + cache +
                '}';
    }
}

class LRUCacheImpl2 {
    private Deque<Integer> doublyQueue;
    private HashSet<Integer> hashSet;
    private int CACHE_SIZE = 0;

    LRUCacheImpl2(int capacity) {
        doublyQueue = new LinkedList<>();
        hashSet = new HashSet<>();
        CACHE_SIZE = capacity;
    }

    public void refer(int page) {
        if (!hashSet.contains(page)) {
            if (doublyQueue.size() == CACHE_SIZE) {
                int last = doublyQueue.removeLast();
                hashSet.remove(last);
            }
        }
        else {
            doublyQueue.remove(page);
        }
        doublyQueue.push(page);
        hashSet.add(page);
    }

    @Override
    public String toString() {
        return "LRUCacheImpl{" +
                "dataStorage=" + doublyQueue +
                '}';
    }
}

class LRUCacheImpl1<T> {

    private Deque<T> dataStorage ;
    private int capacity = 0;

    LRUCacheImpl1(int capacity) {
        dataStorage = new ArrayDeque<>(capacity);
        this.capacity = capacity;
    }

    public T refer(T key){
        if(dataStorage.contains(key)) {
            dataStorage.remove(key);
        }
        if(dataStorage.size() == capacity) {
            dataStorage.removeLast();
        }
        dataStorage.addFirst(key);
        return key;
    }

    @Override
    public String toString() {
        return "LRUCacheImpl{" +
                "dataStorage=" + dataStorage +
                '}';
    }
}

public class LRUCache {
    public static void main(String[] args) {
        LRUCacheImpl3 cache3 = new LRUCacheImpl3(4);
        cache3.refer(1);
        cache3.refer(2);
        cache3.refer(3);
        cache3.refer(1);
        cache3.refer(4);
        cache3.refer(5);
        cache3.refer(2);
        cache3.refer(2);
        cache3.refer(1);
        System.out.println(cache3);

        LRUCacheImpl2 cache2 = new LRUCacheImpl2(4);
        cache2.refer(1);
        cache2.refer(2);
        cache2.refer(3);
        cache2.refer(1);
        cache2.refer(4);
        cache2.refer(5);
        cache2.refer(2);
        cache2.refer(2);
        cache2.refer(1);
        System.out.println(cache2);

        LRUCacheImpl1 cache1 = new LRUCacheImpl1(4);
        cache1.refer(1);
        cache1.refer(2);
        cache1.refer(3);
        cache1.refer(1);
        cache1.refer(4);
        cache1.refer(5);
        cache1.refer(2);
        cache1.refer(2);
        cache1.refer(1);
        System.out.println(cache1);
    }
}

