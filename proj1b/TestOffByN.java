import org.junit.Test;
import static org.junit.Assert.*;


/**
 * @author Cagur
 * @version 1.0
 */
public class TestOffByN {
    static CharacterComparator offByN = new OffByN(5);
    @Test
    public void testOffByN(){
        assertTrue(offByN.equalChars('a','f'));
        assertTrue(offByN.equalChars('b','g'));
        assertFalse(offByN.equalChars('c','e'));
    }
}
