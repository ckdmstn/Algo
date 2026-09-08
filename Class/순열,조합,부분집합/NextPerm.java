package com.ssafy.adpcs;

import java.util.Arrays;

public class NextPerm {

	static int[] p = {1, 2, 3, 4, 5};
	static int N, count;
	
	public static void main(String[] args) {
		count = 0;
		N = p.length;
		
		do {
			count++;
			System.out.println(Arrays.toString(p));
		} while (np(N - 1));
		
		System.out.println(count);
	}

	static boolean np(int end) {
		int i = end;
		
		while ((i > 0) && p[i - 1] > p[i]) i--;
		if (i == 0) return false;
		
		int j = end;
		while (p[i - 1] > p[j]) j--;
		
		int temp = p[i - 1];
		p[i - 1] = p[j];
		p[j] = temp;
		
		int k = end;
		while(i < k) {
			temp = p[i];
			p[i++] = p[k];
			p[k--] = temp;
		}
		
		return true;
	}
	
}
