import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int answer = 0;

        for (int i = A; i <= B; i++) {
            if (i % 3 == 0) {
                answer++;
            } else {
                int num = i;
                while (num > 0) {
                    int digit = num % 10;
                    if (digit == 3 || digit == 6 || digit == 9) {
                        answer++;
                        break;
                    }
                    num /= 10;
                }
            }
        }

        System.out.print(answer);
    }
}