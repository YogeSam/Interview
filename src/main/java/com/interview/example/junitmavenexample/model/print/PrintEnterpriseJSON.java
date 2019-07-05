package com.interview.example.junitmavenexample.model.print;

import com.interview.example.junitmavenexample.model.EnterpriseNode;

public class PrintEnterpriseJSON implements PrintEnterprise {

	public String print(EnterpriseNode e) {
		if(e == null){
			throw new PrintError("Enterprise Node is null");
		}		
		return e.toString();
	}

	public String print(EnterpriseNode[] e) {
		if(e == null){
			throw new PrintError("Enterprise Node Array is null");
		}		
		StringBuilder str = new StringBuilder();
		str.append("[");
		for(EnterpriseNode e1 : e){
			str.append(e1);
		}
		str.append("]");
		return str.toString();
	}

}
