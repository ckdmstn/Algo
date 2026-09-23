import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ability = new int[6];
        int abilitySum = 0;
        for (int i = 0; i < ability.length; i++) {
            ability[i] = Integer.parseInt(st.nextToken());
            abilitySum += ability[i];
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < ability.length - 2; i++) {
            for (int j = i + 1; j < ability.length - 1; j++) {
                for (int k = j + 1; k < ability.length; k++) {
                    int sum = ability[i] + ability[j] + ability[k];
                    int extraSum = Math.abs(abilitySum - sum);
                    answer = Math.min(answer, Math.abs(extraSum - sum));
                }
            }
        }
        
        System.out.println(answer);
    }
}
