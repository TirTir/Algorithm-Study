import java.util.*;

class Solution {
    static class Node {
        int depth;
        String word;
        
        Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
    
    public int solution(String begin, String target, String[] words) {

        Deque<Node> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        
        queue.addLast(new Node(begin, 0));
        visited.add(begin);
        
        while(!queue.isEmpty()) {
            Node cur = queue.removeFirst();
            
            if(cur.word.equals(target)) {
                return cur.depth;
            }
            
            for(int i = 0; i < words.length; i++) {
                if(!visited.contains(words[i]) && getWord(cur.word, words[i])) {
                    queue.addLast(new Node(words[i], cur.depth + 1));
                    visited.add(words[i]);
                }
            }
        }
        
        return 0;
    }
    
    static boolean getWord(String word1, String word2) {
        int count = 0;
        for(int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
            
            if(count > 1) {
                return false;
            }
        }
        
        return true;
    }
}