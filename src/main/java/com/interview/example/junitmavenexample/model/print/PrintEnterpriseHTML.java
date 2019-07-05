package com.interview.example.junitmavenexample.model.print;

import com.interview.example.junitmavenexample.model.EnterpriseNode;

public class PrintEnterpriseHTML implements PrintEnterprise {
	
	public String print(EnterpriseNode[] e) {
		if(e == null){
			throw new PrintError("Enterprise Node Array is null ");
		}
		
		StringBuilder str = new StringBuilder();
		str.append("<DIV>");
		for(EnterpriseNode e1 : e){
			str.append(this.print(e1));
		}
		str.append("</DIV>");
		return str.toString();
	}

	
	public String print(EnterpriseNode e){
		if(e == null){
			throw new PrintError("Enterprise Node is null");
		}
		return "<DIV>" + e.toString() + "</DIV>";
	}

}
