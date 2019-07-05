package com.interview.example.junitmavenexample.model;

import java.util.Objects;

/*
 * Directory
Each node in a tree is composed of following:
EnterpriseId, OrganizationId, EnterpriseName, EnterpriseType

[{"EnterpriseId":-1,"OrganizationId":-1,"EnterpriseName":"Root","EnterpriseType":"Unit"}
 {"EnterpriseId":1,"OrganizationId":1,"EnterpriseName":"East Coast","EnterpriseType":"Unit"}
 {"EnterpriseId":2,"OrganizationId":101,"EnterpriseName":"Westboro Practice","EnterpriseType":"Practice"}
 {"EnterpriseId":3,"OrganizationId":102,"EnterpriseName":"Worcester Practice","EnterpriseType":"Practice"}
 {"EnterpriseId":4,"OrganizationId":201,"EnterpriseName":"Alls Good Facility","EnterpriseType":"Facility"}
 ]


Enterprise Hierarchy

Root
	---- East Coast
		---- Westboro Practice
		----- Worcester Practice
			---- Alls Good Facility


a)	Represent the above Enterprise hierarchy by extending the program
b)	Refactor the program to 
	1.	Build the tree
	2.	Print the tree
	3.	Search the tree - (Use Recursion where applicable)
c)	Write test cases for the refactoring modules 
d)	Find the maximum length of the tree
e)	Find the distance between the intermediate node and the tree
f)  Provide a UML spec of how to provide database operations of saving and loading the tree from the database
 

 * 
 * 
 * 
 * 
 */

import com.google.gson.annotations.Expose;
import com.interview.example.junitmavenexample.model.factory.EnterpriseNodeLoader;

import jsonannotation.JSONSerializable;
import jsonannotation.SerializeToJson;


@JSONSerializable
public class EnterpriseNode {
	
	public EnterpriseNode(int nEnterpriseId, int nOrganizationId, String strEnterpriseName, String strEnterpriseType) {
		super();
		this.EnterpriseId = nEnterpriseId;
		this.OrganizationId = nOrganizationId;
		this.EnterpriseName = strEnterpriseName;
		this.EnterpriseType = strEnterpriseType;
	}
	
	@Expose
	private int EnterpriseId;
	
	@Expose
	private int OrganizationId;
	
	@Expose
	private String EnterpriseName;
	
	private String EnterpriseType;
	
	
	public int getEnterpriseId() {
		return EnterpriseId;
	}
	public void setEnterpriseId(int nEnterpriseId) {
		this.EnterpriseId = nEnterpriseId;
	}
	public int getOrganizationId() {
		return OrganizationId;
	}
	public void setOrganizationId(int nOrganizationId) {
		this.OrganizationId = nOrganizationId;
	}
	public String getEnterpriseName() {
		return EnterpriseName;
	}
	public void setEnterpriseName(String strEnterpriseName) {
		this.EnterpriseName = strEnterpriseName;
	}
	public String getEnterpriseType() {
		return EnterpriseType;
	}
	public void setEnterpriseType(String strEnterpriseType) {
		this.EnterpriseType = strEnterpriseType;
	}
	
	
	@Override
	public String toString() {
		return new SerializeToJson().serialize(this);
	}
	
	public static EnterpriseNode searchBy(EnterpriseNode[] e1, String strType,String strVal){
		EnterpriseNode e = null;
		for(EnterpriseNode node : e1){
			if("EnterpriseId".equals(strType)){
				if(node.getEnterpriseId() == Integer.parseInt(strVal)){
					e = node;
					break;
				}
			}
		}
		return e;
	}
	
	
	
	 public static void main( String[] args ){
		 EnterpriseNode e[] = new EnterpriseNodeLoader().loadFromJSONArray("[{\"EnterpriseId\":\"-1\",\"OrganizationId\":\"-1\",\"EnterpriseName\":\"Root\",\"EnterpriseType\":\"Unit\"}"
					+ ",{\"EnterpriseId\":\"1\",\"OrganizationId\":\"1\",\"EnterpriseName\":\"East Coast\",\"EnterpriseType\":\"Unit\"}"
					+ ",{\"EnterpriseId\":\"2\",\"OrganizationId\":\"101\",\"EnterpriseName\":\"Westboro Practice\",\"EnterpriseType\":\"Practice\"}"
					+ ",{\"EnterpriseId\":\"3\",\"OrganizationId\":\"102\",\"EnterpriseName\":\"Worcester Practice\",\"EnterpriseType\":\"Practice\"}"
					+ ",{\"EnterpriseId\":\"4\",\"OrganizationId\":\"201\",\"EnterpriseName\":\"Alls Good Facility\",\"EnterpriseType\":\"Facility\"}"
					+ "]", EnterpriseNode[].class);
		 //System.out.println(printToJSONString(e));
		 
	}
}
