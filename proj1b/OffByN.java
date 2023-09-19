/**
 * @author Cagur
 * @version 1.0
 */
public class OffByN implements CharacterComparator{

    private int N ;

    @Override
    public boolean equalChars(char x, char y) {
        return x-y == N || y - x == N;
    }

    public OffByN(int N){
        this.N = N;
    }
}
