import java.util.*;

class Solution {
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        return bfs(begin, target, 0, words);
    }

    static int bfs(String begin, String target, int count, String[] words) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(begin, 0)); // 현재 words의 위치, 단어 변환 횟수

        while (!q.isEmpty()) {
            Node curr = q.poll();
            String word = curr.word;
            int cnt = curr.cnt;
            
            if (word.equals(target)) return cnt;
            
            for (int i = 0; i < words.length; i++) {
                String nextWord = words[i];
                int differentAlphabet = 0;
                
                for (int j = 0; j < word.length(); j++) {
                    if (word.charAt(j) != nextWord.charAt(j)) differentAlphabet++;
                    if (differentAlphabet > 1) break;
                }
                
                if (differentAlphabet == 1 && !visited[i]) {
                    q.offer(new Node(nextWord, cnt + 1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }

    static class Node {
        String word;
        int cnt;

        public Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
}