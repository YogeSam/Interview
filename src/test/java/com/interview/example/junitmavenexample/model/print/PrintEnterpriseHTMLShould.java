package com.interview.example.junitmavenexample.model.print;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.interview.example.junitmavenexample.model.EnterpriseNode;



public class PrintEnterpriseHTMLShould {
	@Mock
	EnterpriseNode node; 
	PrintEnterpriseHTML nodeHTML; 
	final String singleDiv = "<DIV>One</DIV>";
	final String doubleDiv = "<DIV><DIV>One</DIV><DIV>One</DIV></DIV>";
	
	
	@Before
	public void setup() {
	    MockitoAnnotations.initMocks(this);
	    when(node.toString()).thenReturn("One");
	    nodeHTML = new PrintEnterpriseHTML();
	}
	
	@Test
	public void print_EnterpriseNode_Array() {
		EnterpriseNode[] nodeArray = {node,node};
		assertThat(nodeHTML.print(nodeArray), is(equalToIgnoringCase(doubleDiv)));
		
	}

	@Test
	public void print_EnterpriseNode() {
		assertThat(nodeHTML.print(node), is(equalToIgnoringCase(singleDiv)));
	}
	
	
	
	@Test(expected = PrintError.class)
	public void throw_exception_when_printing_EnterpriseNode_WithNull() {
		node = null;
		nodeHTML.print(node);
	}

}
