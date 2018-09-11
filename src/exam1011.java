import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jae-seongheo on 2018. 9. 11..
 */
public class exam1011 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = y - x;
            int n = (int)Math.ceil(Math.sqrt(dist));
            int maxDist =(int)Math.pow(Math.ceil(Math.sqrt(dist)),2);
            int maxNum = n*2 -1 ;
            int numberOfTimes = maxNum ;
            if(dist <= maxDist-n) {
                numberOfTimes = maxNum-1;
            }
            System.out.println(numberOfTimes);
        }
    }
}
