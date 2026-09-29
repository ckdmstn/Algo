import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] price = new int[N];
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;

        Arrays.sort(price);

        for (int i = 0; i < N; i++) {
            int sum = 0;
            int count = 0;
            for (int j = 0; j < N; j++) {
                sum += (i == j) ? price[j] / 2 : price[j];
                count++;

                if (sum <= B) {
                    answer = Math.max(answer, count);
                } else {
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}