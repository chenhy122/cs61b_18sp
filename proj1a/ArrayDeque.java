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
        System.arraycopy(items, 0, items, 1, size);
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
        return (double) size / items.length < 0.4;
    }

    public T removeFirst() {
        if (usage()) {
            resize(size / 5);
        }
        T first = items[0];
        size -= 1;
        System.arraycopy(items, 1, items, 0, size);
        return first;
    }

    public T removeLast() {
        if (usage()) {
            resize(size / 5);
        }
        size -= 1;
        return items[size];
    }

    public T get(int index) {
        return items[index];
    }


}
