import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jae-seongheo on 2018. 9. 11..
 */
public class exam1006 {
    static int[][] map;
    static int[][][] cache;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            map = new int[N][2];
            cache = new int[N][4][4];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0;j<N;j++) {
                map[j][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0;j<N;j++) {
                map[j][1] = Integer.parseInt(st.nextToken());
            }
            System.out.println(cover(0, 0, 0, N, W));
        }
    }
    public static int cover(int index, int prev, int last, int n, int w) {
        int result = cache[index][prev][last];
        if (result > 0)
            return result;
        boolean inner, outer, both = false;
        inner = (map[index][0] + map[(index == 0 ? n - 1 : index - 1)][0] <= w);
        outer = (map[index][1] + map[(index == 0 ? n - 1 : index - 1)][1] <= w);
        both = (map[index][0] + map[index][1] <= w);
        if (index == (n - 1)) {
            if (index == 0) {
                cache[index][prev][last] = both ? 1 : 2;
                return cache[index][prev][last];
            }
            result = 2;
            if (last == 0) {
                if (inner && (prev & 1) != 1)
                    result = 1;
                if (outer && (prev < 2))
                    result = 1;
                if (both)
                    result = 1;
                if (inner && outer && prev == 0)
                    result = 0;
            } else if (last == 1) {
                if (outer && prev < 2)
                    result = 1;
            } else if (last == 2) {
                if (inner && (prev & 1) != 1)
                    result = 1;
            }
            cache[index][prev][last] = result;
            return result;
        }
        result = 2 + cover(index + 1, 0, (index != 0) ? last : 0, n, w);
        if (inner && (prev & 1) != 1)
            result = Math.min(result, 1 + cover(index + 1, 1, (index != 0) ? last : 1, n, w));
        if (outer && prev < 2)
            result = Math.min(result, 1 + cover(index + 1, 2, (index != 0) ? last : 2, n, w));
        if (inner && outer && prev == 0)
            result = Math.min(result, cover(index + 1, 3, (index != 0 ? last : 3), n, w));
        if (both)
            result = Math.min(result, 1 + cover(index + 1, 3, (index != 0 ? last : 0), n, w));
        cache[index][prev][last] = result;
        return result;
    }
}
