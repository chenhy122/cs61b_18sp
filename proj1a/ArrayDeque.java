public class ArrayDeque<T> {
    private T[] items;
    private int size;


    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        size = other.size();
        items = (T []) new Object[size];
        System.arraycopy(other, 0, items, 0, size);
    }

    private void resize(int z) {
        T[] a = (T []) new Object[z];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 10);
        }
        if (size != 0) {
            System.arraycopy(items, 0, items, 1, size);
        }
        items[0] = item;
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 10);
        }
        items[size] = item;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i += 1) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    private boolean usage() {
        if (size >= 16) {
            return (double) size / items.length < 0.25;
        }
        return (double) size / items.length < 0.1;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T first = items[0];
        size -= 1;
        System.arraycopy(items, 1, items, 0, size);
        if (usage()) {
            resize(items.length / 2);
        }
        return first;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        size -= 1;
        T last = items[size];
        if (usage()) {
            resize(items.length / 2);
        }
        return last;
    }

    public T get(int index) {
        return items[index];
    }


}
