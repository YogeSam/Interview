package db.unitofwork;

public class DbWorkInterrupted extends RuntimeException {

	public DbWorkInterrupted(String msg) {
		super(msg);
	}

}
