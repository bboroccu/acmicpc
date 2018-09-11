import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jae-seongheo on 2018. 9. 11..
 */
public class exam1009 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int comNum = 1;
            for (int j=0;j<B;j++) {
                comNum *= A;
                comNum %= 10;
            }
            if (comNum == 0)
                System.out.println("10");
            else
                System.out.println(comNum);
        }
    }
}
