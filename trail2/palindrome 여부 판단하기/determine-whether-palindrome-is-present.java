import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String reverse = new StringBuilder(input).reverse().toString();

        if (input.equals(reverse)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}