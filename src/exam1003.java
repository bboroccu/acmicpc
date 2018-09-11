import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jae-seongheo on 2018. 9. 11..
 */
public class exam1003 {
    static int[] count = new int[41];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(st.nextToken());
        for (int i=0;i<t;i++) {                         //시간복잡도 O(n)
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            for (int j=0;j<count.length;j++) {
                count[j] = -1;
            }
            if (n == 0)
                System.out.println("1 0");
            else if (n == 1)
                System.out.println("0 1");
            else {
                fibonacci(n);
                System.out.println(count[n - 1] + " " + count[n]);
            }
        }
    }
    public static int fibonacci(int n) {
        if (count[n] > -1)
            return count[n];
        else {
            if (n == 0) {
                count[n] = 0;
                return count[n];
            } else if (n == 1) {
                count[n] = 1;
                return count[n];
            } else {
                count[n] = fibonacci(n - 1) + fibonacci(n - 2);
                return count[n];
            }
        }
    }
}
