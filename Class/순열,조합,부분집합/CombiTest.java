import java.util.Arrays;

public class CombiTest {

	static int[] p = {1, 2, 3, 4, 5};
	static int N, R;
	static int[] num;
	static int count;
	
	public static void main(String[] args) {
		N = p.length;
		R = 3;
		num = new int[R];
		count = 0;
		
		combi(0, 0);
		System.out.println(count);
	}
	
	static void combi(int cnt, int start) {
		if (cnt == R) {
			System.out.println(Arrays.toString(num));
			count++;
			return;
		}
		
		for (int i = start; i < N; i++) {
			num[cnt] = p[i];
			combi(cnt + 1, i + 1);                                                                                                                                                                 
			num[cnt] = 0;
		}
	}

}
