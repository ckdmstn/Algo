import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = sc.nextInt();
        }
        
        Arrays.sort(nums);
        int answer = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            answer = Math.max(answer, nums[i] + nums[nums.length - i - 1]);
        }

        System.out.println(answer);
    }
}