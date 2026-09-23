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
        for (int i = 1; i < ability.length; i++) {
            int team1 = ability[0] + ability[i];
             
            int nextIdx = (i == 1) ? 2 : 1;
            for (int j = 1; j < ability.length; j++) {
                if (j == i || j == nextIdx) continue;
                 
                int team2 = ability[nextIdx] + ability[j];
                int team3 = abilitySum - team1 - team2;
                 
                int maxAbility = Math.max(Math.max(team1, team2), team3);
                int minAbility = Math.min(Math.min(team1, team2), team3);
                
                answer = Math.min(answer, maxAbility - minAbility);
            }
        }
        
        System.out.println(answer);
    }
}
