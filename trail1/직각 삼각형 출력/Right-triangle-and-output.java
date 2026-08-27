import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N * 2; i += 2) {
            for (int j = 1; j <= i; j++) {
                sb.append("*");
            } sb.append("\n");
        }

        System.out.println(sb);
    }
}