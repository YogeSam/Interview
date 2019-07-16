package patterns.behavioral.template;


import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.InOrder;

import patterns.console.Console;

public class PokerShould {


	@Test
	public void call_init_start_end_when_play_is_called() {
		Console console = mock(Console.class);
		Poker poker = new Poker(console);
		poker.play();
		
		InOrder inorder = inOrder(console);
		inorder.verify(console).printLine("Poker:Init");
		inorder.verify(console).printLine("Poker:start");
		inorder.verify(console).printLine("Poker:end");
		
	}

}
