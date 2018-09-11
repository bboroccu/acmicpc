import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by jae-seongheo on 2018. 9. 11..
 */
public class exam1005 {
    private static int[][] node;
    private static int[] delay;
    private static int[] indegree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            node = new int[N][N];
            delay = new int[N];
            indegree = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0;j<N;j++) {
                delay[j] = Integer.parseInt(st.nextToken());
            }
            for (int k=0;k<K;k++) {
                st = new StringTokenizer(br.readLine(), " ");
                int X = Integer.parseInt(st.nextToken()) - 1;
                int Y = Integer.parseInt(st.nextToken()) - 1;
                node[X][Y] = 1;
                indegree[Y]++;
            }
            st = new StringTokenizer(br.readLine(), " ");
            int W = Integer.parseInt(st.nextToken()) - 1;
            System.out.println(totalTime(W));
        }
    }
    public static int totalTime(int dest) {
        Queue<Integer> q = new LinkedList<Integer>();
        int len = indegree.length;
        int[] result = new int[len];
        for (int i=0;i<len;i++) {
            if (indegree[i] == 0) {
                result[i] = delay[i];
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int v = q.poll();
            for (int i=0;i<len;i++) {
                if (node[v][i] == 1) {
                    result[i] = Math.max(result[i], result[v] + delay[i]);
                    if (--indegree[i] == 0)
                        q.add(i);
                }
            }
        }
        return result[dest];
    }
}
