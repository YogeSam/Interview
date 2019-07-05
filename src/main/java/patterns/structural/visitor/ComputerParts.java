package patterns.structural.visitor;

import java.util.ArrayList;
import java.util.List;

public class ComputerParts {

	List<Part> listofParts = new ArrayList<Part>();
	AssemblyVisitor assemblyVisitor = new AssemblyVisitor();
	String strAssembled = "";
	
	public void add(Part p){
		strAssembled += p.accept(assemblyVisitor);
		listofParts.add(p);
	}
	
	public String getAssembled(){
		return strAssembled;
	}
	
}
