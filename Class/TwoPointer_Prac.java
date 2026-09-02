import java.io.*;
import java.util.*;

public class TwoPointer_Prac {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =  Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int start = 0;
		int end = n - 1;
		int answer = 0;
		while (start < end) {
			int num = nums[start] + nums[end];
			if (num == x) {
				answer++;
				start++;
				end--;
			} else if (num > x) {
				end--;
			} else if (num < x) {
				start++;
			}
		}
		
		System.out.println(answer);
	}

}