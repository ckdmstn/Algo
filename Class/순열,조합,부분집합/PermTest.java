package com.ssafy.adpcs;

import java.util.Arrays;

public class PermTest {

	static int[] p = {1, 2, 3, 4, 5};
	static int N, R;
	static int[] num;
	static int count;
	
	public static void main(String[] args) {
		N = p.length;
		R = 3;
		num = new int[R];
		count = 0;
		
		perm(0, 0);
		System.out.println(count);
	}
	
	static void perm(int cnt, int flag) {
		if (cnt == R) {
			System.out.println(Arrays.toString(num));
			count++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0) continue;
			
			num[cnt] = p[i];
			
			perm(cnt + 1, flag | (1 << i));                                                                                                                                                                 
			num[cnt] = 0;
		}
	}

}
