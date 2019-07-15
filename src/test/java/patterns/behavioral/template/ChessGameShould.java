package patterns.behavioral.template;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;

public class ChessGameShould {

	@Test
	public void play_should_call_game_to_init_start_end() {
		Console console = mock(Console.class);
		Chess chess = new Chess(console);
		chess.play();
		
		InOrder inorder = inOrder(console);
		inorder.verify(console).printLine("Chess:Init");
		inorder.verify(console).printLine("Chess:start");
		inorder.verify(console).printLine("Chess:end");
		
	}

}
