package com.ssafy.edu.third;

public interface IMagic {
	
	int[][] getMagic();
	
	void make();
	
	void print();
	
	default void info() {
		System.out.println("MagicSquare!! made by honeyhoney");
	}
	
}
