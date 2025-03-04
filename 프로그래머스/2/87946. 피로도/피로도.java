class Solution {
    static int max = 0; 
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(k, 0, dungeons);
        
        return max;
    }
    
    static void dfs(int k, int cnt, int[][] dungeons) { // 현재 피로도, 탐험한 던전 개수
        max = Math.max(max, cnt); // 던전 탐험 횟수 업데이트
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(k - dungeons[i][1], cnt + 1, dungeons);
                visited[i] = false;
            }
        }
    }
}