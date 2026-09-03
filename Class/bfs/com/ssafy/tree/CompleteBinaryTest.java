package com.ssafy.tree;

public class CompleteBinaryTest {

	public static void main(String[] args) {
		String[] names = {"가가", "나나", "다다", "라라", "마마", "바바", "사사"};
		CompleteBinaryTree<String> tree = new CompleteBinaryTree<>(names.length);
		
		for (String name : names) {
			tree.add(name);
		}
		
		tree.bfs();
	}

}
