import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt() - 1;

        int[][] arr = new int[n][n];

        initialize(sc, m, arr);

        String dfsResult = makeDfsResult(start, arr);

        boolean [] visited = new boolean[n];
        String bfsResult = bfs(arr, start, visited);

        System.out.println(dfsResult.substring(0, dfsResult.length()-1));
        System.out.println(bfsResult.substring(0, bfsResult.length()-1));
    }
  
    private static void initialize(Scanner sc, int m, int[][] arr) {
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
    }

    private static String bfs(int[][] arr, int start, boolean[] visited) {
        String bfsResult = "";
        Queue<Integer>queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int point = queue.poll();
            bfsResult += (point+1) + " ";
            for(int i=0;i<arr[point].length;i++){
                if(arr[point][i]==1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return bfsResult;
    }

    private static String makeDfsResult(int start, int[][] arr) {
        Set<Integer>dfsSet = new LinkedHashSet<>();
        dfsSet.add(start +1);
        dfs(arr, dfsSet, start);
        String dfsResult = "";
        for(Integer dfsInteger : dfsSet){
            dfsResult += dfsInteger + " ";
        }
        return dfsResult;
    }

    private static void dfs(int[][] arr, Set<Integer> dfsResult, int start) {
        for(int i=0;i<arr[start].length;i++){
            if(dfsResult.size() == arr.length){
                break;
            }
            if(arr[start][i]==1 && !dfsResult.contains(i+1)){
                dfsResult.add(i+1);
                dfs(arr, dfsResult, i);
            }
        }
    }
}
