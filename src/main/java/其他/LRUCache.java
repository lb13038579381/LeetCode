package 其他;

public class LRUCache {
    private int size;
    private LRUNode head;
    private int capicity;

    public LRUCache(int capacity) {
        this.capicity = capacity;
    }

    public LRUCache() {
        this.capicity = 10;
    }

    private boolean put(int key, int val) {
        if (head == null) {
            head = new LRUNode(key, val);
            this.size = 1;
            return true;
        }
        if (head.key == key) {
            if (head.val != val) {
                head.val = val;
            }
            return true;
        }
        LRUNode process = head;
        if (process.next == null) {
            LRUNode newHead = new LRUNode(key, val);
            newHead.next = head;
            head.pre = newHead;
            newHead.pre = null;
            head = newHead;
            this.size++;
            if (size > capicity) {
                removeLast();
            }
            return true;
        }
        while (process != null) {
            if (process.key == key) {
                LRUNode next = process.next;
                LRUNode pre = process.pre;
                pre.next = next;
                next.pre = pre;
                process.next = head;
                head.pre = process;
                process.pre = null;
                head = process;
                return true;
            }
            process = process.next;
        }
        LRUNode newHead = new LRUNode(key, val);
        newHead.next = head;
        head.pre = newHead;
        newHead.pre = null;
        head = newHead;
        this.size++;
        if (size > 5) {
            removeLast();
        }
        return true;
    }

    private int get(int key) {
        if (head.key == key) {
            return head.val;
        }
        LRUNode process = head;
        while (process != null) {
            if (process.key == key) {
                LRUNode pre = process.pre;
                LRUNode next = process.next;
                pre.next = next;
                process.next = head;
                head.pre = process;
                process.pre = null;
                head=process;
                return process.val;
            }
            process = process.next;
        }
        return -1;
    }

    private void removeLast() {
        if (head == null) {
            return;
        }
        int cur = 0;
        LRUNode process = head;
        while (process != null) {
            cur++;
            if (cur > this.capicity) {
                LRUNode pre = process.pre;
                pre.next = null;
                size--;
                return;
            }
            process = process.next;
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        LRUNode process = head;
        while (process.next != null) {
            res.append(process.key + " = " + process.val).append(",");
            process = process.next;
        }
        res.append(process.key + " = " + process.val);
        return res.toString();
    }

    class LRUNode {
        int key;
        int val;
        LRUNode next;
        LRUNode pre;

        public LRUNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) throws Exception {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        lruCache.put(5, 5);
        lruCache.put(6, 6);
        lruCache.put(7, 7);
        lruCache.put(5, 5);
        lruCache.put(7, 7);
        lruCache.put(7, 8);
        lruCache.put(7, 9);
        lruCache.get(6);
        System.out.println(lruCache);
        lruCache.get(3);
        System.out.println(lruCache);
    }
}
