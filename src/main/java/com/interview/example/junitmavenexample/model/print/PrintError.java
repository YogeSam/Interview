package com.interview.example.junitmavenexample.model.print;

public class PrintError extends RuntimeException {

	public PrintError(String strError, Throwable err){
		super(strError, err);
	}
	

	public PrintError(String strError){
		super(strError);
	}	
}
