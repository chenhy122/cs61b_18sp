public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i += 1) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        return helper(d);
    }

    private boolean helper(Deque<Character> d) {
        if (d.size() == 0 || d.size() == 1) {
            return true;
        }
        Character first = d.removeFirst();
        Character last = d.removeLast();
        if (first != last) {
            return false;
        }
        return helper(d);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        return helper(d, cc);
    }

    private boolean helper(Deque<Character> d, CharacterComparator cc) {
        if (d.size() == 0 || d.size() == 1) {
            return true;
        }
        Character first = d.removeFirst();
        Character last = d.removeLast();
        if (!cc.equalChars(first, last)) {
            return false;
        }
        return helper(d, cc);
    }

}
