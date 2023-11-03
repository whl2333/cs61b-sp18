import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {

    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String word1 = "animal";
        boolean actual1 = palindrome.isPalindrome(word1);
        assertFalse(actual1);
        String word2 = "a";
        boolean actual2 = palindrome.isPalindrome(word2);
        assertTrue(actual2);
        String word3 = "";
        boolean actual3 = palindrome.isPalindrome(word3);
        assertTrue(actual3);
        String word4 = "abccba";
        boolean actual4 = palindrome.isPalindrome(word4);
        assertTrue(actual4);
    }
    @Test
    public void testOffByOneIsPalindrome() {
        CharacterComparator cc = new OffByOne();
        String word1 = "b";
        assertTrue(palindrome.isPalindrome(word1,cc));

        String word2 = "bdca";
        assertTrue(palindrome.isPalindrome(word2,cc));

        String word3 = "bdfca";
        assertTrue(palindrome.isPalindrome(word3,cc));

        String word4 = "bafca";
        assertFalse(palindrome.isPalindrome(word4,cc));
    }
    @Test
    public void testOffByNPalindrome() {
        CharacterComparator cc = new OffByN(3);
        String test1 = "abfed";
        assertTrue(palindrome.isPalindrome(test1,cc));
    }
}
