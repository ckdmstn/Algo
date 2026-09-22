import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[19][19];
        
        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        boolean gameOver = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1 || arr[i][j] == 2) {
                    int flag = checkFive(i, j, arr[i][j]);
                    if (flag == 0) continue;
                    System.out.println(arr[i][j]);
                    if (flag == 1) System.out.println((i + 1) + " " + (j + 3));
                    if (flag == 2) System.out.println((i + 3) + " " + (j + 1));
                    if (flag == 3) System.out.println((i + 3) + " " + (j - 1));
                    if (flag == 4) System.out.println((i + 3) + " " + (j + 3));
                    gameOver = true;
                    break;
                }
            }
        }

        if (!gameOver) System.out.println(0);
    }
    
    static int checkFive(int r, int c, int color) {
        // 가로 확인
        boolean flag = true;
        for (int j = 1; j < 5; j++) {
            if (c + j >= arr.length || arr[r][c + j] != color) {
                flag = false;
                break;
            }
        }
        if (flag == true) return 1;
        
        // 세로 확인
        flag = true;
        for (int i = 1; i < 5; i++) {
            if (r + i >= arr.length || arr[r + i][c] != color) {
                flag = false;
                break;
            }
        }
        if (flag == true) return 2;
        
        // 대각선 (왼쪽) 확인
        flag = true;
        for (int i = 1; i < 5; i++) {
            if(r + i >= arr.length || c - i < 0 || arr[r + i][c - i] != color) {
                flag = false;
                break;
            }
        }
        if (flag == true) return 3;
        
        // 대각선 (오른쪽) 확인
        flag = true;
        for (int i = 1; i < 5; i++) {
            if(r + i >= arr.length || c + i >= arr.length || arr[r + i][c + i] != color) {
                flag = false;
                break;
            }
        }
        if (flag == true) return 4;
        
        return 0;
    }
}