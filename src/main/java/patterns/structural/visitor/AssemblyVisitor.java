package patterns.structural.visitor;

public class AssemblyVisitor implements Visitor {

	
	public String visit(MousePart a) {
		// TODO Auto-generated method stub
		return "Mouse Assembled";

	}
	
	public String visit(KeyboardPart a) {
		// TODO Auto-generated method stub
		return "Keyboard  Assembled";
	}
	
	public String visit(MonitorPart a) {
		// TODO Auto-generated method stub
		return "Monitor Assembled";
	}

	public String visit(Part a) {
		// TODO Auto-generated method stub
		if(a instanceof MousePart){
			return visit((MousePart) a);
		}else if(a instanceof KeyboardPart){
			return visit((KeyboardPart) a);
		}else if(a instanceof MonitorPart){
			return visit((MonitorPart) a);
		}
		
		return "";
	}

	
	

}
