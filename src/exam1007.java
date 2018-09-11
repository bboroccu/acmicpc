import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jae-seongheo on 2018. 9. 11..
 */
public class exam1007 {
    static double min = Double.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            min = Double.MAX_VALUE;
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int[][] value = new int[N][2];
            int[] target = new int[N/2];
            for (int j=0;j<N;j++) {
                st = new StringTokenizer(br.readLine(), " ");
                value[j][0] = Integer.parseInt(st.nextToken());
                value[j][1] = Integer.parseInt(st.nextToken());
            }
            combination(target, 0, N, N /2, 0, value);
            System.out.println(min);
        }
    }
    public static void combination(int[] arr, int index, int n, int k, int target, int[][] value) {
        if (k == 0)
            min = calcMin(arr, index, value);
        else if (n == target)
            return;
        else {
            arr[index] = target;
            combination(arr, index + 1, n, k - 1, target + 1, value);
            combination(arr, index, n, k, target + 1, value);
        }
    }
    public static double calcMin(int[] arr, int length, int[][] value) {
        double sumX = 0;
        double sumY = 0;
        double vectorLength = 0;
        for (int i=0;i<value.length;i++) {
            sumX += value[i][0];
            sumY += value[i][1];
        }
        for (int i=0;i<length;i++) {
            sumX -= (value[arr[i]][0]) * 2;
            sumY -= (value[arr[i]][1]) * 2;
        }
        vectorLength = Math.sqrt((sumX * sumX + sumY * sumY));
        if (vectorLength < min)
            min = vectorLength;
        return min;
    }
}
