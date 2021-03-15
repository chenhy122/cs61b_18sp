public class LinkedListDeque<T> {
    private DequeNode sentinela;
    private int size;
    private DequeNode sentinelb;

    private class DequeNode {
        private DequeNode prev;
        private T item;
        private DequeNode next;
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

    public void addFirst(T item) {
        sentinela.next = new DequeNode(sentinela, item, sentinela.next);
        sentinela.next.next.prev = sentinela.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinelb.prev = new DequeNode(sentinelb.prev, item, sentinelb);
        sentinelb.prev.prev.next = sentinelb.prev;
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
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
        sentinela.next = sentinela.next.next;
        sentinela.next.prev = sentinela;
        size -= 1;
        return result;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T result = sentinelb.prev.item;
        sentinelb.prev = sentinelb.prev.prev;
        sentinelb.prev.next = sentinelb;
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

    public T getRecursive(int index) {
        DequeNode d = this.sentinela;
        LinkedListDeque l = new LinkedListDeque();
        for (int i = 0; i < this.size(); i += 1) {
            l.addLast((T) this.get(i));
        }

        if (this.size <= index) {
            return null;
        }
        if (index != 0) {
            l.removeFirst();
            return (T) l.getRecursive(index - 1);
        }
        return d.next.item;
    }

}
