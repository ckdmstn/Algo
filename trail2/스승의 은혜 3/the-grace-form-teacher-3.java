import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] price = new int[N];
        int[] fee = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            price[i] = Integer.parseInt(st.nextToken());
            fee[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int[] cost = new int[N];

            for (int j = 0; j < N; j++) {
                if (i == j) {
                    cost[j] = price[j] / 2 + fee[j];
                } else {
                    cost[j] = price[j] + fee[j];
                }
            }

            Arrays.sort(cost);

            int sum = 0;
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (sum + cost[j] > B) break;
                sum += cost[j];
                count++;
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}