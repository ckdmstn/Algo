package com.ssafy.edu.third;
import java.util.Scanner;
public class MagicSquareMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요.");
		int n = sc.nextInt();
		
		IMagic magic = null;
		
		try {
			magic = MagicFactory.getInstance(n);
		} catch (NotFoundMagicSquareException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		MagicFactory.print(magic);
	}
}
