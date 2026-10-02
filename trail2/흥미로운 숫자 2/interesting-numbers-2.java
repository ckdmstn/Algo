import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int answer = 0;

        for (int i = x; i <= y; i++) {
            boolean flag = true;
            int n1 = -1, n2 = -1;
            int num = i;
            int[] count = new int[10];
            int digits = 0;

            while (num != 0) {
                count[num % 10]++;
                num /= 10;
                digits++;
            }

            int distinctCount = 0;
            boolean hasOne = false;
            for (int d = 0; d < 10; d++) {
                if (count[d] > 0) {
                    distinctCount++;
                    if (count[d] == 1) hasOne = true;
                }
            }

            if (distinctCount == 2 && hasOne) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}