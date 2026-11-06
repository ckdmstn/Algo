import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        int right = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right += arr[i];
        }

        int left = right / M, answer = right;

        while (left <= right) {
            if (isPossible((left + right) / 2)) {
                answer = (left + right) / 2;
                right = (left + right) / 2 - 1;
            } else {
                left = (left + right) / 2 + 1;
            }
        }

        System.out.println(answer);

    }

    // 최댓값이 max인 경우에 M개의 구간으로 나눌 수 있는지 판별
    public static boolean isPossible(int max) {
        int count = 0;

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count >= M) {
                return false;
            }

            if (sum + arr[i] <= max) {
                sum += arr[i];
            } else {
                if (arr[i] > max) return false;

                sum = arr[i];
                count++; 
            }
        }

        return count < M;
    }
}