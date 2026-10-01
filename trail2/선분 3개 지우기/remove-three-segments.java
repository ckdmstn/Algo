import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    boolean[] arr = new boolean[101];
                    boolean flag = false;
                    for (int m = 0; m < N; m++) {
                        if (m == i || m == j || m == k) continue;
                        
                        for (int n = a[m]; n <= b[m]; n++) {
                            if (arr[n]) {
                                flag = true;
                                break;
                            }
                            arr[n] = true;
                        }

                        if (flag) break;
                    }

                    if (!flag) answer++;
                }
            }
        }

        System.out.println(answer);
    }
}