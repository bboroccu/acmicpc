import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jae-seongheo on 2018. 9. 11..
 */
public class exam1010 {
    private static int map[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            map = new int[30][30];
            System.out.println(counting(M, N));
        }
    }
    public static int counting(int n, int r) {
        int result = map[n][r];
        if (result > 0)
            return result;
        if (r == 0 || n == r) return map[n][r] = 1;
        return map[n][r] = counting(n - 1, r - 1) + counting(n - 1, r);
    }
}
