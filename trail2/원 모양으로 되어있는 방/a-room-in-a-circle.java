import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] room = new int[N];
        for (int i = 0; i < N; i++) {
            room[i] = Integer.parseInt(br.readLine());
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int distance = 0;
            for (int j = 1; j < N; j++) {
                distance += j * room[(j + i) % N];
            }
            answer = Math.min(answer, distance);
        }
        
        System.out.println(answer);
    }
}