package com.ssafy.adpcs;

import java.io.*;
import java.util.*;

public class NPTest {
	
	static int N, totalCnt;
	static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		// 사전식 순열 생성하기 위해 오름차순 정렬
		Arrays.sort(numbers);
		
//		totalCnt = 0;
//		long start = System.nanoTime();
		do {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
		} while (np());
		
//		long end = System.nanoTime();
//		System.out.println((end - start) / 1_000_000_000.0);
		System.out.println("총 경우의 수 : " + totalCnt);
	}
	
	// 다음 순열이 존재하면 true, 아니면 false 반환
	static boolean np() { 
		// step1. 꼭대기 위치 뒤쪽부터 탐색하며 찾기
		final int N = numbers.length;
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i]) i--;
		
		if (i == 0) return false; // 현 순열의 상태가 가장 큰 순열의 상태
		
		// step2. 꼭대기 바로 앞 위치와 교환할 큰 수를 뒤쪽부터 탐색하며 찾기
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j]) j--;
		
		// step3. 꼭대기 바로 앞 위치의 수와 큰 수 교환
		swap(i - 1, j);
		
		// step4. 꼭대기부터 맨 마지막 위치까지의 값들 오름차순 정렬
		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}
		
		return true;
	}
	
	static void swap(int a, int b) {
		int temp = numbers[a];
		numbers[a] = numbers[b];
		numbers[b] = temp;
	}
}
