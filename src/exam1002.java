import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jae-seongheo on 2018. 9. 11..
 */
public class exam1002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {                                  //시간복잡도 O(n)
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int X = x2 - x1;
            int Y = y2 - y1;
            if (X == 0 && Y == 0) {
                if (r1 == r2)
                    System.out.println("-1");
                else if (r1 != r2)
                    System.out.println("0");
            } else {
                double p = Math.sqrt((X * X) + (Y * Y));
                if ((r1 + r2) > p && Math.abs(r1 - r2) < p)
                    System.out.println("2");
                else if ((r1 + r2) == p || Math.abs(r1 - r2) == p)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
}
