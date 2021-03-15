public class Test {
    public static void main(String[] args) {
        ArrayDeque a = new ArrayDeque();
        a.addLast(0);
        a.addLast(1);
        a.addLast(2);
        a.addFirst(3);
        a.addFirst(4);
        a.addFirst(5);
        a.removeFirst();
        a.removeLast();
        a.printDeque();
        a.addLast(6);
        a.addFirst(7);
        a.addFirst(5);
        a.addFirst(5);
        a.addFirst(5);
        a.addFirst(5);
        a.addFirst(5);
        a.removeLast();
    }

}
