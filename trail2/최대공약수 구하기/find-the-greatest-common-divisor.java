import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int min = Math.min(n, m);
        int answer = 1;
        for (int i = 2; i <= min; i++) {
            if (n % i == 0 && m % i == 0) {
                answer = i;
            }
        }

        System.out.print(answer);
    }
}