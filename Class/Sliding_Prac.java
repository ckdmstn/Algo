import java.io.*;
import java.util.*;

public class Sliding_Prac {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 공지된 일수 (1 ~ 100,000)
		int m = Integer.parseInt(st.nextToken()); // 일하려는 연속 일수
		
		int[] dailyPay = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			dailyPay[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		for (int i = 0; i < m; i++) {
			answer += dailyPay[i];
		}
		
		int money = answer;
		for (int i = m; i < n; i++) {
			money = money - dailyPay[i - m] + dailyPay[i];
			answer = Math.max(answer, money);
		}
		
		System.out.println(answer);
	}

}
