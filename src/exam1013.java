import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jae-seongheo on 2018. 9. 19..
 */
public class exam1013 {
    static final int FAIL = 9;
    public static int[][] tr = new int[][]{
        {5, 1},     //0
        {2, FAIL},  //1
        {3, FAIL},  //2
        {3, 4},     //3
        {5, 7},     //4
        {FAIL, 6},  //5
        {5, 1},     //6
        {8, 7},     //7
        {3, 6},     //8
        {FAIL, FAIL}    //9
    };
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(st.nextToken());
        for (int i=0;i<t;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String N = st.nextToken();
            if (chk(N))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    public static boolean chk(String str) {
        int state = 0;
        for (int i=0;i<str.length();i++) {
            int ch = str.charAt(i) - 48;
            state = tr[state][ch];
        }
        return (state == 4 || state == 6 || state == 7) ? true : false;
    }

}
