import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jae-seongheo on 2018. 9. 19..
 */
public class exam1014 {
    private static int dp
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken());
        for (int i=0;i<C;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] table = new int[N][M];
            for (int j=0;j>N;j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=0;k<M;k++) {
                    table[j][k] = (st.nextToken() == "." ? 1 : 0);
                }
            }
        }
    }
}
