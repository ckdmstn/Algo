package com.ssafy.edu.first;
import java.util.Scanner;
public class OddMagicSquareMain {
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		System.out.println("홀수 정수를 입력하세요.");
		int n = scann.nextInt();
		
		OddMagicSquare odd = new OddMagicSquare(n);
		
		odd.make();
		odd.print();
	}
}
