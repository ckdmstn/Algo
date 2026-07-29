package com.ssafy.edu.second;
import java.util.Scanner;
public class MagicSquareMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("4의배수 정수를 입력하세요.");
		int n = sc.nextInt();
		
		MagicSquare magic = null;
		
		if (n % 2 == 1) {
			magic = new OddMagicSquare(n);
		} else if (n % 4 == 0) {
			magic = new FourMagicSquare(n);
		} else if (n % 4 == 2) {
			magic = new SixMagicSquare(n);
		}
		
		print(magic);
		
	}

	private static void print(MagicSquare magic) {
		magic.make();
		magic.print();
	}
}
