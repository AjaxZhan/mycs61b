/**
 * @author Cagur
 * @version 1.0
 */
public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for(int i=0;i<word.length();i++){
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    /** Return true if word is palindrome*/
    public boolean isPalindrome(String word){
        Deque<Character> deque = wordToDeque(word);
        int i = 0, j = deque.size()-1;
        while(!(j - i == 1) && !(i==j)){
            if(deque.get(i) != deque.get(j)) return false;
            i ++ ;
            j --;
        }
        return true;
    }
    /** Return true if the word is palindrome according to the cc*/
    public boolean isPalindrome(String word,CharacterComparator cc){
        Deque<Character> deque = wordToDeque(word);
        int i = 0, j =deque.size()-1;
        while(!(j - i == 1) && !(i==j)){
            if(!cc.equalChars(deque.get(i),deque.get(j))){
                return false;
            }
            i +=1;
            j -=1;
        }
        return true;
    }
}
