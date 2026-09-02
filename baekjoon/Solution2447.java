import java.util.Scanner;

public class Solution2447 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append((isCenter(i, j, N)) ? " " : "*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static boolean isCenter(int r, int c, int n) {
		if (n == 1) return false;
		
		boolean isMiddleRow = (r % n) / (n / 3) == 1;
		boolean isMiddleCol = (c % n) / (n / 3) == 1;
		
		if (isMiddleRow && isMiddleCol) {
			return true;
		}
		
		return isCenter(r, c, n / 3);
	}

}
