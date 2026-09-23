import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        for (int num = 123; num <= 987; num++) {
            if (!isValidNumber(num)) continue;
            
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                int[] count = checkCount(num, arr[i][0]);
                if (!(count[0] == arr[i][1] && count[1] == arr[i][2])) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) answer++;
        }
        
        System.out.println(answer);
    }
    
    static boolean isValidNumber(int num) {
        int n1 = num % 10;
        int n2 = (num / 10) % 10;
        int n3 = num / 100;
        
        if (n1 == n2 || n2 == n3 || n1 == n3) return false;
        if (n1 == 0 || n2 == 0 || n3 == 0) return false;
        return true;
    }
    
    static int[] checkCount(int num1, int num2) { // num1 : 정답
        int n1_100 = num1 / 100;
        int n1_10 = (num1 / 10) % 10;
        int n1_1 = num1 % 10;
        int n2_100 = num2 / 100;
        int n2_10 = (num2 / 10) % 10;
        int n2_1 = num2 % 10;
        
        int[] count = new int[2];
        
        if (n2_100 == n1_100) count[0]++;
        else if (n2_100 == n1_10 || n2_100 == n1_1) count[1]++;
        
        if (n2_10 == n1_10) count[0]++;
        else if (n2_10 == n1_100 || n2_10 == n1_1) count[1]++;
        
        if (n2_1 == n1_1) count[0]++;
        else if (n2_1 == n1_10 || n2_1 == n1_100) count[1]++;
        
        return count;
    }
}