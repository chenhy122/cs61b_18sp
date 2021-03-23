public class OffByN implements CharacterComparator {
    private int num;

    public OffByN(int N) {
        num = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        int diff2 = y - x;
        return diff == num || diff2 == num;
    }
}
