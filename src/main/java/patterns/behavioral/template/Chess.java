package patterns.behavioral.template;

public class Chess extends Game {

	
	private Console console;

	public Chess(Console console) {
		// TODO Auto-generated constructor stub
		this.console = console;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		console.printLine("Chess:Init");
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		console.printLine("Chess:start");
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		console.printLine("Chess:end");
	}

}
