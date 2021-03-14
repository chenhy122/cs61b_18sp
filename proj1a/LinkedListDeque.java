public class LinkedListDeque<T> {
    private DequeNode sentinela;
    private int size;
    private DequeNode sentinelb;

    public class DequeNode {
        public DequeNode prev;
        public T item;
        public DequeNode next;
        public DequeNode(DequeNode a, T i, DequeNode b) {
            prev = a;
            item = i;
            next = b;
        }
    }

    public LinkedListDeque() {
        sentinela = new DequeNode(null, null, null);
        sentinelb = new DequeNode(sentinela, null, null);
        sentinela.next = sentinelb;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque other) {
        sentinela = new DequeNode(null, null, null);
        sentinelb = new DequeNode(sentinela, null, null);
        sentinela.next = sentinelb;
        size = 0;

        for (int i = 0; i < other.size(); i += 1) {
            addLast((T) other.get(i));
        }
    }
    public void addFirst(T item) {
        sentinela.next = new DequeNode(sentinela, item, sentinela.next);
        size += 1;
    }

    public void addLast(T item) {
        sentinelb.prev = new DequeNode(sentinelb.prev, item, sentinelb);
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque() {
        DequeNode d = sentinela;
        while (d.next != sentinelb) {
            System.out.print(d.next.item + " ");
            d = d.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T result = sentinela.next.item;
        sentinela.next = new DequeNode(sentinela, sentinela.next.next.item, sentinela.next.next);
        size -= 1;
        return result;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T result = sentinelb.prev.item;
        sentinelb.prev = new DequeNode(sentinelb.prev.prev, sentinelb.prev.prev.item, sentinelb);
        size -= 1;
        return result;
    }

    public T get(int index) {
        DequeNode d = sentinela;
        if (size <= index) {
            return null;
        }
        while (index != 0) {
            d = d.next;
            index -= 1;
        }
        return d.next.item;
    }


}