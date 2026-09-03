package com.ssafy.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CompleteBinaryTree<T> {

	private Object[] nodes;
	private int lastIndex;
	private final int SIZE;
	
	public CompleteBinaryTree(int size) {
		SIZE = size;
		nodes = new Object[SIZE + 1];
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(T e) {
		if (isFull()) return;
		nodes[++lastIndex] = e;
	}
	
	public void bfs0() {
		if (isEmpty()) return;
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.offer(1);
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			
			System.out.println(nodes[current]);
			
			int child = current * 2;
			if (child <= lastIndex) queue.offer(child); // 왼쪽 자식 
			if (child + 1 <= lastIndex) queue.offer(child + 1); // 오른쪽 자식
			
		}
	}
	
	public void bfs() {
		if (isEmpty()) return;
		
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] {1, 0});
		
		while (!queue.isEmpty()) {
			int[] info = queue.poll();
			int current = info[0];
			int breadth = info[1];
			
			System.out.println(nodes[current] + " : " + breadth);
			
			int child = current * 2;
			if (child <= lastIndex) queue.offer(new int[] {child, breadth + 1}); // 왼쪽 자식 
			if (child + 1 <= lastIndex) queue.offer(new int[] {child + 1, breadth + 1}); // 오른쪽 자식
			
		}
	}
	
	public void bfs2() {
		if (isEmpty()) return;
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.offer(1);
		
		int breadth = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (--size >= 0) {
				int current = queue.poll();
			
				System.out.println(nodes[current] + " : " + breadth);
				
				int child = current * 2;
				if (child <= lastIndex) queue.offer(child); // 왼쪽 자식 
				if (child + 1 <= lastIndex) queue.offer(child + 1); // 오른쪽 자식
			}
			++breadth;
		}
	}
}
