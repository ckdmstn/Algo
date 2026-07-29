package com.ssafy.edu.second;

public class OddMagicSquare extends MagicSquare {
	
	public OddMagicSquare(int n) {
		super(n);
	}
	
	public OddMagicSquare( ) {
		this(3);    // 생성자 오버로딩 - OddMagicSquare(int n)을 이용
	}
	
	public void make() {   // 홀수 마방진 만들기
		int x = 0;           // 가장 윗줄
		int y = n / 2;         // 중앙
		
		for (int i = 1; i <= n * n ; i++) {
			int temX = x;    // 옮기기전 위치 저장
			int temY = y;    
			
			magic[x][y] = i; // 1 ~ n x n 대입
			
			// 위로 이동
			if (x - 1 < 0 ){ // 윗벽
				x = n - 1;
			} else {
				x--;     // 정상 x = x - 1;
			}
			
			// 왼쪽으로 이동
			if (y - 1 < 0 ){ // 왼쪽 벽
				y = n - 1;
			} else {
				y--;     // 정상 y = y - 1;
			}
			
			if (magic[x][y] != 0){ // 이미 존재
				x = temX + 1;  // x 원위치 + 1
				y = temY;    // y 원위치
			}
		} 
	}
	
} 
