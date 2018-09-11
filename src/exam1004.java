import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jae-seongheo on 2018. 9. 11..
 */
public class exam1004 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {                         //시간복잡도 O(n)
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int j=0;j<n;j++) {
                boolean in1, in2;
                st = new StringTokenizer(br.readLine(), " ");
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int d = (cx - x1) * (cx -x1) + (cy -y1) * (cy - y1);
                in1 = (d > r * r) ? false : true;
                d = (cx - x2) * (cx - x2) + (cy - y2) * (cy - y2);
                in2 =  (d > r * r) ? false : true;
                if (in1 != in2)
                    count++;
            }
            System.out.println(count);
        }
    }
}
