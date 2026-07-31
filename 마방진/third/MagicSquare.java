package com.ssafy.edu.third;

public abstract class MagicSquare implements IMagic {
	
	protected int [][] magic; // 2차원 배열 선언
	protected int n;          // 마방진 크기 n X n

	public int[][] getMagic() {
		return magic;
	} 
	
	public MagicSquare(int n) {
		magic = new int[n][n]; // 2차원 배열 생성, 초기화
		this.n = n;            // 마방진 크기 결정
	}
	
	//public abstract void make();
	
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
		m[2 * n + 1] = sumDia();       // 대각선의 합
		
		for (int i = 1; i < m.length; i++) {
			if(m[0] == 0 || m[0] != m[i]){ // 하나라도 다르면 마방진이 아님
				isM = false;
				break;
			}
		}
		
		return isM;
	}
} 
