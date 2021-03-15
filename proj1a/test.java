public class Test {
    public static void main(String[] args) {
        ArrayDeque a = new ArrayDeque();
        a.addLast(1);
        a.addLast(2);
        a.addFirst(5);
        a.addFirst(6);
        System.out.println(a.removeFirst());
        System.out.println(a.removeLast());

        System.out.print(a.isEmpty());
    }

}
