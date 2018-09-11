import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by jae-seongheo on 2018. 9. 11..
 */
public class exam1012 {
    public static int[][] field;
    public static boolean[][] invisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            field = new int[N][M];
            invisited = new boolean[N][M];
            for (int j=0;j<K;j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }
            int count = 0;
            for (int row=0;row<N;row++) {
                for (int column=0;column<M;column++) {
                    if (field[row][column] == 1 && invisited[row][column] == false) {
                        bfs(column, row, M, N);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static void bfs(int x, int y, int m, int n) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{x,y});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int[] dx = {1, 0 ,-1, 0};
            int[] dy = {0, -1, 0, 1};
            for (int i=0;i<4;i++) {
                int p_x = p[0] + dx[i];
                int p_y = p[1] + dy[i];
                if (p_x >= 0 && p_x < m && p_y >= 0 && p_y < n && invisited[p_y][p_x] == false && field[p_y][p_x] == 1) {
                    q.add(new int[]{p_x, p_y});
                    invisited[p_y][p_x] = true;
                }
            }
        }
    }
}
