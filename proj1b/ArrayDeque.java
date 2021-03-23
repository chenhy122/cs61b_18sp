public class ArrayDeque<Item> implements Deque<Item>{
    private Item[] items;
    private int size;


    public ArrayDeque() {
        items = (Item []) new Object[8];
        size = 0;
    }

    private void resize(int z) {
        Item[] a = (Item []) new Object[z];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    @Override
    public void addFirst(Item item) {
        if (size == items.length) {
            resize(size * 10);
        }
        if (size != 0) {
            System.arraycopy(items, 0, items, 1, size);
        }
        items[0] = item;
        size += 1;
    }

    @Override
    public void addLast(Item item) {
        if (size == items.length) {
            resize(size * 10);
        }
        items[size] = item;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i += 1) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    @Override
    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Item first = items[0];
        size -= 1;
        System.arraycopy(items, 1, items, 0, size);
        if (items.length >= 16 && (double) size / items.length < 0.25) {
            resize(items.length / 4);
        }
        return first;
    }

    @Override
    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }
        size -= 1;
        Item last = items[size];
        if (items.length >= 16 && (double) size / items.length < 0.25) {
            resize(items.length / 4);
        }
        return last;
    }

    @Override
    public Item get(int index) {
        return items[index];
    }


}
