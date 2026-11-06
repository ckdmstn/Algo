import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int answer = Integer.MAX_VALUE;
        
        for (int length = 1; length <= n; length++) {
            HashSet<String> hs = new HashSet<>();
            boolean flag = true;

            for (int i = 0; i <= str.length() - length; i++) {
                String s = str.substring(i, i + length);

                if (!hs.add(s)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                answer = length;
                break;
            }
        }

        System.out.println(answer);
    }
}