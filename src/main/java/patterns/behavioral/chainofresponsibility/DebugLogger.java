package patterns.behavioral.chainofresponsibility;

public class DebugLogger extends Logger {

	public DebugLogger(Logger logger) {
		this.logger = 	logger;
	}

	@Override
	public void print(int loglevel, String message) {
		// TODO Auto-generated method stub
		if(loglevel <= Logger.DEBUG){
			console.printLine("DEBUG:" + message);
		}
		super.print(loglevel, message);
	}

}
