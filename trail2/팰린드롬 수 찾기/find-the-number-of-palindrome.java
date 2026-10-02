import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int answer = 0;

        for (int i = x; i <= y; i++) {
            String s = String.valueOf(i);
            String reversed = new StringBuilder(s).reverse().toString();
            if (s.equals(reversed)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}