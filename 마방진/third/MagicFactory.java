package com.ssafy.edu.third;

public class MagicFactory {

	public static IMagic getInstance(int n) throws NotFoundMagicSquareException {
		IMagic magic = null;
		
		if (n % 2 == 1) {
			magic = new OddMagicSquare(n);
		} else if (n % 4 == 0) {
			magic = new FourMagicSquare(n);
		} else if (n % 4 == 2) {
			magic = new SixMagicSquare(n);
		} else throw new NotFoundMagicSquareException(n + "에 해당되는 예외가 없습니다.");
		
		return magic;
	}
	
	public static void print(IMagic magic) {
		magic.make();
		magic.print();
	}

}
