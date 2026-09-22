import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] num = new String[N];
        for (int i = 0; i < N; i++) {
            num[i] = br.readLine();
        }
        
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (!isCarry(num[i], num[j], num[k])) {
                        int sum = Integer.parseInt(num[i]) + Integer.parseInt(num[j]) + Integer.parseInt(num[k]);
                        answer = Math.max(answer, sum);
                    }
                }
            }
        }
        
        System.out.println((answer == Integer.MIN_VALUE) ? -1 : answer);
    }
    
    static boolean isCarry(String num1, String num2, String num3) {
        int maxLength = Math.max(Math.max(num1.length(), num2.length()), num3.length());
        for (int i = 0; i < maxLength; i++) {
            int sum = 0;
            if (num1.length() - i - 1 >= 0) {
                sum += Integer.parseInt(String.valueOf(num1.charAt(num1.length() - i - 1)));
            } 
            if (num2.length() - i - 1 >= 0) {
                sum += Integer.parseInt(String.valueOf(num2.charAt(num2.length() - i - 1)));
            }
            if (num3.length() - i - 1 >= 0) {
                sum += Integer.parseInt(String.valueOf(num3.charAt(num3.length() - i - 1)));
            }
            
            if (sum >= 10)
                return true;
        }
        
        return false;
    }
}