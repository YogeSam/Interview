package patterns.behavioral.chainofresponsibility;

import patterns.console.Console;

public abstract class Logger {

	public static final int DEBUG = 3;
	public static final int ERROR = 2;
	public static final int ALL = 1;
	
	protected Console console = new Console();
	protected Logger logger;
	
	public static Logger buildLogger(Console console) {
		// TODO Auto-generated method stub
		AllLogger allLogger = new AllLogger();
		allLogger.setConsole(console);
		
		ErrorLogger errorLogger = new ErrorLogger(allLogger);
		errorLogger.setConsole(console);
		
		DebugLogger debugLogger = new DebugLogger(errorLogger);
		debugLogger.setConsole(console);
		
		return debugLogger;
		
	}

	public void setConsole(Console console) {
		// TODO Auto-generated method stub
		this.console = console;
	}

	public void print(int loglevel, String message){
		if(this.logger != null){
			this.logger.print(loglevel, message);
		}
	}

}
