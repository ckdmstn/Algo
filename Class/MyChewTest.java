package com.ssafy.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyChewTest {

	public static void main(String[] args) {
		int N = 20; // 총 마이쮸 개수
		int person = 0; // 사람 번호
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] {++person, 1});
		int personNum = -1;
		
		while (N > 0) {
			int[] p = queue.poll(); // 마이쮸 제공
			N -= (N >= p[1]) ? p[1] : N;
			
			if (N == 0) {
				personNum = p[0];
				break;
			} else {
				queue.offer(new int[] {p[0], ++p[1]});
				queue.offer(new int[] {++person, 1});
			}
		}
		
		System.out.println(personNum);
	}

}
