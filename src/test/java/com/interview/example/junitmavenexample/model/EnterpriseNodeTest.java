package com.interview.example.junitmavenexample.model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class EnterpriseNodeTest {

	@Test
	public void testEnterpriseNodeObject() {
		EnterpriseNode e = new EnterpriseNode(-1, -1, "Root" , "Unit");
		assert(e.getEnterpriseId() == -1);
		assert(e.getEnterpriseType().equals("Unit"));
		assert(e.getEnterpriseName().equals("Root"));
		assert(e.getOrganizationId() == -1);
		assert(e.toString().length() > 0 && e.toString().indexOf("Root") >= 0);
	}	

	@Test
	public void testEnterpriseNodeObjectConstructionFromJSON() {
		EnterpriseNode e = EnterpriseNode.loadFromJSON("{\"EnterpriseId\":\"-1\",\"OrganizationId\":\"-1\",\"EnterpriseName\":\"Root\",\"EnterpriseType\":\"Unit\"}");
		assert(e.getEnterpriseId() == -1);
		assert(e.getEnterpriseType().equals("Unit"));
		assert(e.getEnterpriseName().equals("Root"));
		assert(e.getOrganizationId() == -1);
		System.out.println(e);
		assert(EnterpriseNode.printToJSONString(e).length() > 0 && EnterpriseNode.printToJSONString(e).indexOf("Root") >= 0);
	}	

	@Test
	public void testEnterpriseNodeArrayConstructionFromJSON() {
		EnterpriseNode e[] = EnterpriseNode.loadFromJSONArray("[{\"EnterpriseId\":\"-1\",\"OrganizationId\":\"-1\",\"EnterpriseName\":\"Root\",\"EnterpriseType\":\"Unit\"}"
				+ ",{\"EnterpriseId\":\"1\",\"OrganizationId\":\"1\",\"EnterpriseName\":\"East Coast\",\"EnterpriseType\":\"Unit\"}"
				+ ",{\"EnterpriseId\":\"2\",\"OrganizationId\":\"101\",\"EnterpriseName\":\"Westboro Practice\",\"EnterpriseType\":\"Practice\"}"
				+ ",{\"EnterpriseId\":\"3\",\"OrganizationId\":\"102\",\"EnterpriseName\":\"Worcester Practice\",\"EnterpriseType\":\"Practice\"}"
				+ ",{\"EnterpriseId\":\"4\",\"OrganizationId\":\"201\",\"EnterpriseName\":\"Alls Good Facility\",\"EnterpriseType\":\"Facility\"}"
				+ "]");
		assert(e.length == 5);
		assert(e[0].getEnterpriseId() == -1);
		assert(e[0].getEnterpriseType().equals("Unit"));
		assert(e[0].getEnterpriseName().equals("Root"));
		assert(e[0].getOrganizationId() == -1);
		assert(e[4].toString().length() > 0 && e[4].toString().indexOf("Alls Good Facility") >= 0);
	}	
	
	@Test
	public void testEnterpriseNodeArrayConstructionFromJSONFile() {
		EnterpriseNode e[] = null;
		try{
			e = EnterpriseNode.loadFromJSONFile("C:\\testinput.txt");
			assert(e.length == 5);
			assert(e[0].getEnterpriseId() == -1);
			assert(e[0].getEnterpriseType().equals("Unit"));
			assert(e[0].getEnterpriseName().equals("Root"));
			assert(e[0].getOrganizationId() == -1);
			assert(e[4].toString().length() > 0 && e[4].toString().indexOf("Root") >= 0);
		}catch(IOException e1){
			assertTrue("Failed Loading from file", false);
		}
	}		
	
	
	@Test
	public void testsearchEnterpriseNode() {
		EnterpriseNode e1[] = EnterpriseNode.loadFromJSONArray("[{\"EnterpriseId\":\"-1\",\"OrganizationId\":\"-1\",\"EnterpriseName\":\"Root\",\"EnterpriseType\":\"Unit\"}"
				+ ",{\"EnterpriseId\":\"1\",\"OrganizationId\":\"1\",\"EnterpriseName\":\"East Coast\",\"EnterpriseType\":\"Unit\"}"
				+ ",{\"EnterpriseId\":\"2\",\"OrganizationId\":\"101\",\"EnterpriseName\":\"Westboro Practice\",\"EnterpriseType\":\"Practice\"}"
				+ ",{\"EnterpriseId\":\"3\",\"OrganizationId\":\"102\",\"EnterpriseName\":\"Worcester Practice\",\"EnterpriseType\":\"Practice\"}"
				+ ",{\"EnterpriseId\":\"4\",\"OrganizationId\":\"201\",\"EnterpriseName\":\"Alls Good Facility\",\"EnterpriseType\":\"Facility\"}"
				+ "]");		
		EnterpriseNode e = EnterpriseNode.searchBy(e1, "EnterpriseId","2");
		assert(e != null);
		assert(e.getEnterpriseType().equals("Practice"));
	}		
	
	
}
