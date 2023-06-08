import java.util.*;

/**
 * 기본적으로 bfs를 이용해서 풀었습니다.
 * 다른 bfs 문제와 다른 점이라면 시작 점이 하나가 아니라 여러 개가 될 수 있다는 점이 있었네요.
 * 여러 시작 점들을 리스트에 담은 뒤에 bfs를 돌면서 방문한 노드들은 삭제하는 방식으로 진행했습니다.
 *   - 방문한 노드들은 삭제하면 n 번째 네트워크를 돌면서 해당 네트워크의 노드는 삭제하기 때문에 다른 네트워크의 노드만 남습니다.
 * 이외에는 기존의 bfs와 동일합니다.
 */

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // 모든 노드들을 담을 list를 생성하고 노드들을 담음
        List<String> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            list.add(String.valueOf(i));
        }
        
        while(!list.isEmpty()){
            // 새로운 네트워크마다 새로운 방문 기록 생성
            boolean[]visited = new boolean[n];
            int start = Integer.parseInt(list.remove(0));
            bfs(start, list, computers, visited);
            answer++;
        }
        return answer;
    }

    private void bfs(int start, List<String> list, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int point = queue.poll();
            for(int i=0;i<computers[point].length;i++){
                if(i!=point && computers[point][i] == 1 && !visited[i]){
                    queue.add(i);
                    // 방문 노드 list에서 제거
                    list.remove(String.valueOf(i));
                    visited[i] =true;
                }
            }
        }
    }
}
