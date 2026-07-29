package com.ssafy.edu.first;

public class OddMagicSquare {
	private int [][] magic; // 2차원 배열 선언
	private int n;          // 마방진 크기 n X n

	public int[][] getMagic() {
		return magic;
	}
	
	public OddMagicSquare(int n) {
		magic = new int[n][n]; // 2차원 배열 생성, 초기화
		this.n = n;            // 마방진 크기 결정
	}
	
	public OddMagicSquare( ) {
		this(3);    // 생성자 오버로딩 - OddMagicSquare(int n)을 이용
	}
	
	public void make( ){   // 홀수 마방진 만들기
		int x = 0;           // 가장 윗줄
		int y = n / 2;         // 중앙
		
		for (int i = 1; i <= n * n ; i++) {
			int temX = x;    // 옮기기전 위치 저장
			int temY = y;    
			//System.out.printf("(%d,%d)\t", x, y);
			
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
		} //for
	}
	
	public void print(){
		System.out.println();
		System.out.println(n + " is magic : " + isMagic()); // 마장진 완성?
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(magic[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	//row 행에 대한 열들의 합
	private int sumRow(int row){
		int tot = 0;
		for (int i = 0; i < n; i++) {
			tot += magic[row][i];
		}
		return tot;
	}
	
	// col 열에 대한  행들의 합
	private int sumCol(int col){
		int tot = 0;
		for (int i = 0; i < n; i++) {
			tot += magic[i][col];
		}
		return tot;
	}
	
	// 역 대각선 (2,0)(1,1),(0,2)
	private int sumDia(){
		int tot = 0;
		for (int i = 0; i < n ; i++) {
			tot += magic[i][n-1-i];
		}
		return tot;
	}
	
	// 대각선 (0,0),(1,1),(2,2)
	private int sumReverseDia(){
		int tot = 0;
		for (int i = 0; i < n ; i++) {
			tot += magic[i][i];
		}
		return tot;
	}
	
	// 마방진이 잘 되었는가를 판단
	private  boolean isMagic( ){
		boolean isM = true;
		int[] m = new int[2 * n + 2];  // 행 수 n + 열 수 n + 대각선 1 + 역대각선 1
		
		for (int i = 0; i < n; i++) {
			m[i] = sumRow(i);      // 0, 1, 2 행의 합
			m[i + n] = sumCol(i);    // 3, 4, 5 열의 합
		}
		m[2 * n] = sumReverseDia();  // 역대각선의합
		m[2 * n +1 ] = sumDia();       // 대각선의 합
		
		for (int i = 1; i < m.length; i++) {
			if(m[0] == 0 || m[0] != m[i]){ // 하나라도 다르면 마방진이 아님
				isM = false;
				break;
			}
		}
		
		return isM;
	}
} //class 
