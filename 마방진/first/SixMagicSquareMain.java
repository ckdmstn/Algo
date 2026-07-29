package com.ssafy.edu.first;
import java.util.Scanner;

public class SixMagicSquareMain {
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		System.out.println("6, 10, 14 정수(4n+2)를 입력하세요.");
		int n = scann.nextInt();
		
		SixMagicSquare sms = new SixMagicSquare(n);
		
		sms.make();
		sms.print();
	}
	
}
/*
1) A 0, 3
3	0	0	0	0	0	
0	3	0	0	0	0	
3	0	0	0	0	0	
0	0	0	0	0	0	
0	0	0	0	0	0	
0	0	0	0	0	0	

2) B 2, 1
3	0	0	2	2	2	
0	3	0	2	2	2	
3	0	0	2	2	2	
0	0	0	0	0	0	
0	0	0	0	0	0	
0	0	0	0	0	0	

3) C, D 
3	0	0	2	2	2	
0	3	0	2	2	2	
3	0	0	2	2	2	
0	3	3	1	1	1	
3	0	3	1	1	1	
0	3	3	1	1	1

4) 
27	0	0	18	18	18	
0	27	0	18	18	18	
27	0	0	18	18	18	
0	27	27	9	9	9	
27	0	27	9	9	9	
0	27	27	9	9	9

5)  4)의 각 지역 자리에 3마방을 더함
6	1	8	
7	5	3	
2	9	4

33	1	8	24	19	26	
7	32	3	25	23	21	
29	9	4	20	27	22	
6	28	35	15	10	17	
34	5	30	16	14	12	
2	36	31	11	18	13	
*/