package com.interview.example.junitmavenexample.model.print;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.interview.example.junitmavenexample.model.EnterpriseNode;


public class PrintEnterpriseHTMLTest {

	@Test
	public void testPrintEnterpriseNodeArray() {
		EnterpriseNode node = mock(EnterpriseNode.class);
		when(node.toString()).thenReturn("One");
		EnterpriseNode[] nodeArray = {node,node};
		PrintEnterpriseHTML nodeHTML = new PrintEnterpriseHTML();
		assertThat(nodeHTML.print(nodeArray), is(equalToIgnoringCase("<DIV><DIV>One</DIV><DIV>One</DIV></DIV>")));
		
	}

	@Test
	public void testPrintEnterpriseNode() {
		EnterpriseNode node = mock(EnterpriseNode.class);
		when(node.toString()).thenReturn("One");
		PrintEnterpriseHTML nodeHTML = new PrintEnterpriseHTML();
		assertThat(nodeHTML.print(node), is(equalToIgnoringCase("<DIV>One</DIV>")));
	}
	
	
	
	@Test(expected = PrintError.class)
	public void testPrintEnterpriseNodeWithNull() {
		PrintEnterpriseHTML nodeHTML = new PrintEnterpriseHTML();
		EnterpriseNode node = null;
		nodeHTML.print(node);
	}

}
