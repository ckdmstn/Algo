package com.ssafy.edu.third;

public class NotFoundMagicSquareException extends Exception {

	public NotFoundMagicSquareException() {
		super("3 이상을 입력하세요.");
	}

	public NotFoundMagicSquareException(String message) {
		this();
	}

}
