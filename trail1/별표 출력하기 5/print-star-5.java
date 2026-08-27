import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = N; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < i; k++) {
                    sb.append("*");
                } sb.append(" ");
            } sb.append("\n");
        }

        System.out.println(sb);
    }
}