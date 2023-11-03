import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    @Test
    public void testEqualChars() {
        CharacterComparator cc1 = new OffByN(5);
        assertTrue(cc1.equalChars('a','f'));

        CharacterComparator cc2 = new OffByN(3);
        assertTrue(cc2.equalChars('d','a'));
    }
}
