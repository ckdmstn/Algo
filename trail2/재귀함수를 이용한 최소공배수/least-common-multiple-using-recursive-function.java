import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int num = arr[0];
        for (int i = 1; i < n; i++) {
            num = (num * arr[i]) / func(num, arr[i]);
        }

        System.out.print(num);
    }

    public static int func(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return func(n2, n1 % n2);
    }
}