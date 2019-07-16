package patterns.behavioral.chainofresponsibility;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

import patterns.console.Console;

public class ALoggerShould {
	
	final String MESSAGE = "This is a message";
	Logger logger;
	Console console;
	
	
	@Before
	public void setup(){
		console = mock(Console.class);
		logger = Logger.buildLogger(console);
		
	}

	@Test
	public void print_debug_log_only_when_specified_by_debug_logging_level() {
		logger.print(Logger.DEBUG, MESSAGE);
		InOrder inorder = inOrder(console);
		inorder.verify(console).printLine("DEBUG:" + MESSAGE);
	}
	
	@Test
	public void print_error_and_debug_log_only_when_specified_by_error_logging_level() {
		logger.print(Logger.ERROR, MESSAGE);
		InOrder inorder = inOrder(console);
		inorder.verify(console).printLine("DEBUG:" + MESSAGE);
		inorder.verify(console).printLine("ERROR:" + MESSAGE);
	}
	
	@Test
	public void print_all_error_and_debug_log_only_when_specified_by_all_logging_level() {
		logger.print(Logger.ALL, MESSAGE);
		InOrder inorder = inOrder(console);
		inorder.verify(console).printLine("DEBUG:" + MESSAGE);
		inorder.verify(console).printLine("ERROR:" + MESSAGE);
		inorder.verify(console).printLine("ALL:" + MESSAGE);
	}

	
}
