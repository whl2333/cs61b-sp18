import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
    static CharacterComparator offByOne = new OffByOne();
    @Test
    public void testOffByOne1() {
        boolean actual1 = offByOne.equalChars('b','a');
        assertTrue(actual1);
    }
    @Test
    public void testOffByOne2() {
        boolean actual2 = offByOne.equalChars('a','b');
        assertTrue(actual2);
    }
    @Test
    public void testOffByOne3() {
        boolean actual3 = offByOne.equalChars('A','b');
        assertFalse(actual3);
    }
    @Test
    public void testOffByOne4() {
        boolean actual4 = offByOne.equalChars('&','%');
        assertTrue(actual4);
    }

}
