public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> deque = new LinkedListDeque<>();
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            deque.addLast(ch);
        }
        return deque;
    }

//    public boolean isPalindrome(String word){
//        int i=0,j=word.length()-1;
//        while(i<j){
//            if(word.charAt(i)!=word.charAt(j))
//                return false;
//            i++;
//            j--;
//        }
//        return true;
//    }

//    public boolean isPalindrome(String word) {
//        Deque<Character> deque = wordToDeque(word);
//        while(!deque.isEmpty()) {
//            char head = deque.removeFirst();
//            char tail = deque.removeLast();
//            if (head!=tail)
//                return false;
//        }
//        return true;
//    }

    public static boolean isEqual(int i, int j, String word) {
        if (j<=i)
            return true;
        if (word.charAt(i) == word.charAt(j)) {
            return isEqual(i+1,j-1,word);
        }
        return false;
    }

    public boolean isPalindrome(String word) {
        return isEqual(0,word.length()-1,word);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {

        Deque<Character> deque = wordToDeque(word);
        while(!deque.isEmpty() && deque.size()!=1) {
            if (!cc.equalChars(deque.removeFirst(), deque.removeLast()))
                return false;
        }
        return true;
    }
}
