import java.io.*;
import java.util.*;

public class TwoPointer_Prac2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =  Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = 0, answer = 0;
		int sum = 0;
		while (start < n) {
			if (sum < m && end < n) {
		        sum += nums[end++];
		    } else if (sum >= m) {
		        if (sum == m) {
		            answer++;
		        }
		        sum -= nums[start++];
		    } else { // end == n
		        break;
		    }
		}
		
		System.out.println(answer);
	}

}
