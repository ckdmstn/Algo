import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b;
        char[] c = a.toCharArray();
        if (a.contains("0")) {
            for (int i = 0; i < c.length; i++) {
                if (c[i] == '0') {
                    c[i] = '1';
                    break;
                }
            }
        } else {
            c[c.length - 1] = '0';
        }
        
        System.out.println(Integer.parseInt(new String(c), 2));
    }
}