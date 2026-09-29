import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 치즈 개수
        int D = Integer.parseInt(st.nextToken()); // 치즈 먹은 기록 수
        int S = Integer.parseInt(st.nextToken()); // 아픈 기록 수
        
        int[][] eat = new int[N + 1][M + 1];
        for (int[] row : eat) Arrays.fill(row, Integer.MAX_VALUE);
        for (int i = 0; i < D; i++) {
            st = new StringTokenizer(br.readLine());
            int personNumber = Integer.parseInt(st.nextToken());
            int cheeseNumber = Integer.parseInt(st.nextToken());
            int eatTime = Integer.parseInt(st.nextToken());
            eat[personNumber][cheeseNumber] = Math.min(eat[personNumber][cheeseNumber], eatTime);
        }

        boolean[] cheese = new boolean[M + 1]; // true : 안 상함, false : 상한 치즈 후보 가능성 O
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int sickPerson = Integer.parseInt(st.nextToken());
            int sickTime = Integer.parseInt(st.nextToken());

            for (int j = 1; j < eat[0].length; j++) {
                if (eat[sickPerson][j] >= sickTime || eat[sickPerson][j] == Integer.MAX_VALUE) {
                    cheese[j] = true;
                }
            }
        }

        boolean[] possiblySick = new boolean[N + 1];
        for (int i = 1; i < cheese.length; i++) {
            if (!cheese[i]) {
                for (int j = 1; j < eat.length; j++) {
                    if (eat[j][i] != Integer.MAX_VALUE) {
                        possiblySick[j] = true;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < possiblySick.length; i++) {
            if (possiblySick[i]) answer++;
        }

        System.out.println(answer);
    }
}
