package com.ssafy.edu.first;

public class SixMagicSquare {
	
	private int[][] magic;
	private int n;
	
	public int[][] getMagic() {
		return magic;
	}
	
	public SixMagicSquare(int n) {
		magic = new int[n][n];
		this.n = n;
	}
	
	public SixMagicSquare() {
		this(6);
	}
	
	public void make(){
		makeA();
		makeB();
		makeCD();
		makeMulti();
		makeOdd();
	}
	
	private void makeA() {
		for (int i = 0; i < n / 2 ; i++) {
			for (int j = 0; j < n / 4 ; j++) {
				if (i == n / 4){
					magic[i][j + 1] = 3;
				} else {
					magic[i][j] = 3;
				}
			}
		}
	}
	
	private void makeB() {
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				magic[i][j + n / 2] = 1;
			}
		}
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n / 2 - (n / 4 - 1); j++) {
				magic[i][j + n / 2] = 2;
			}
		}
	}
	
	private void makeCD() {
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				if (magic[i][j] == 0){
					magic[i + n / 2][j] = 3;
				} else {
					magic[i + n / 2][j] = 0;
				}
				
				if (magic[i][j + n / 2] == 1){
					magic[i + n / 2][j + n / 2] = 2;
				} else {
					magic[i + n / 2][j + n / 2] = 1;
				}
			}
		}
	}
	
	private void makeMulti() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				magic[i][j] *= (n / 2 * n / 2);
			}
		}
	}
	
	private void makeOdd() {
		OddMagicSquare odd = new OddMagicSquare(n / 2);
		odd.make();    
		int[][] mm = odd.getMagic();
		
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j <n / 2 ; j++) {
				magic[i][j] += mm[i][j];
				magic[i][j + n / 2] += mm[i][j];
				magic[ i+ n / 2][j] += mm[i][j];
				magic[i + n / 2][j + n / 2] += mm[i][j];
			}
		}
	}
	
	public void print(){
		System.out.println();
		System.out.println(n + " is magic : " + isMagic());
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(magic[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	private  boolean isMagic( ){
		boolean isM = true;
		int[] m = new int[2 * n + 2];
		
		for (int i = 0; i < n; i++) {
			m[i] = sumRow(i);
			m[i + n] = sumCol(i);
		}
		m[2 * n]=sumReverseDia();
		m[2 * n + 1]=sumDia();
		
		for (int i = 1; i < m.length; i++) {
			if(m[0] == 0 || m[0] != m[i]){
				isM = false;
				break;
			}
		}
		
		return isM;
	}
	
	private int sumRow(int row){
		int tot = 0;
		for (int i = 0; i < n; i++) {
			tot += magic[row][i];
		}
		return tot;
	}
	
	private int sumCol(int col){
		int tot = 0;
		for (int i = 0; i < n; i++) {
			tot += magic[i][col];
		}
		return tot;
	}
	
	private int sumDia(){
		int tot = 0;
		for (int i = 0; i < n ; i++) {
			tot += magic[i][n-1-i];
		}
		return tot;
	}
	
	private int sumReverseDia(){
		int tot = 0;
		for (int i = 0; i < n ; i++) {
			tot += magic[i][i];
		}
		return tot;
	}
}
