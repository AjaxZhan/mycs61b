import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars(){
        assertTrue(offByOne.equalChars('x','y'));
        assertTrue(offByOne.equalChars('f','e'));
        assertFalse(offByOne.equalChars('x','z'));
        assertFalse(offByOne.equalChars('a','z'));
        assertFalse(offByOne.equalChars('%','%'));
        assertFalse(offByOne.equalChars('a','A'));
        assertTrue(offByOne.equalChars('A','B'));
        assertFalse(offByOne.equalChars('A','C'));
    }
}
