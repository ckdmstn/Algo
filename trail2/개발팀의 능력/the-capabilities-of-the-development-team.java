import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ability = new int[5];
        int abilitySum = 0;
        for (int i = 0; i < ability.length; i++) {
            ability[i] = Integer.parseInt(st.nextToken());
            abilitySum += ability[i];
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < ability.length; i++) {
            int team1 = ability[i];
            
            int nextIdx = (i == 0) ? 1 : 0;
            for (int j = 1; j < ability.length; j++) {
                if (j == i || j == nextIdx) continue;
                
                int team2 = ability[nextIdx] + ability[j];
                int team3 = abilitySum - team1 - team2;
                
                if (!(team1 == team2 || team2 == team3 || team1 == team3)) {
                    int maxAbility = Math.max(Math.max(team1, team2), team3);
                    int minAbility = Math.min(Math.min(team1, team2), team3);
                    
                    answer = Math.min(answer, maxAbility - minAbility);
                }
            }
        }
        
        System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
    }
}
