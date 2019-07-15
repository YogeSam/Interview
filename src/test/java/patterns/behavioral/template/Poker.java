package patterns.behavioral.template;

public class Poker extends Game {

	public Poker(Console console) {
		super();
		this.console = console;
	}

	private Console console;
	
	@Override
	public void end() {
		// TODO Auto-generated method stub
		console.printLine("Poker:end");
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		console.printLine("Poker:start");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		console.printLine("Poker:Init");
	}

}
