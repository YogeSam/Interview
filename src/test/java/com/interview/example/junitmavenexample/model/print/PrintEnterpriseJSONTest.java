package com.interview.example.junitmavenexample.model.print;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.interview.example.junitmavenexample.model.EnterpriseNode;

public class PrintEnterpriseJSONTest {

	@Test
	public void testPrintEnterpriseNodeArray() {
		EnterpriseNode node = mock(EnterpriseNode.class);
		when(node.toString()).thenReturn("One");
		EnterpriseNode[] nodeArray = {node,node};
		PrintEnterpriseJSON nodeJSON= new PrintEnterpriseJSON();
		assertThat(nodeJSON.print(nodeArray), is(equalToIgnoringCase("[OneOne]")));
		
	}

	@Test
	public void testPrintEnterpriseNode() {
		EnterpriseNode node = mock(EnterpriseNode.class);
		when(node.toString()).thenReturn("One");
		PrintEnterpriseJSON nodeJSON = new PrintEnterpriseJSON();
		assertThat(nodeJSON.print(node), is(equalToIgnoringCase("One")));
	}
	
	
	
	@Test(expected = PrintError.class)
	public void testPrintEnterpriseNodeWithNull() {
		PrintEnterpriseJSON nodeJSON = new PrintEnterpriseJSON();
		EnterpriseNode node = null;
		nodeJSON.print(node);
	}
}
