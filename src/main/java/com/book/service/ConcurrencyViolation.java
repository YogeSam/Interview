package com.book.service;

public class ConcurrencyViolation extends RuntimeException {
	public ConcurrencyViolation(String msg) {
		super(msg);
	}


}
