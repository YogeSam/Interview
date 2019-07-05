package patterns.behaviorial.memento;

public class Customer {
	private  String name;
	private  int id;
	
	private  Memento backup = new Keeper();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		saveState();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		saveState();
		this.id = id;
	}
	public Customer(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	private void saveState(){

		Customer c = new Customer(this.name, this.id);
		backup.setState((Object)c);
	}
	
	public void undoState(){
		Customer c = (Customer)backup.getState();
		if(c != null){
			this.name = c.name;
			this.id = c.id;
		}
		
	}
	

}
