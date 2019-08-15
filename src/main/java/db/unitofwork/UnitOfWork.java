package db.unitofwork;
import java.sql.Connection;
import java.sql.SQLException;

import dbConnection.DbConnection;

public abstract class UnitOfWork {
	protected Connection con = null;
	
	public UnitOfWork() {
		super();
		try{
			con = DbConnection.getConnection();
		}catch(Exception e){
			throw new DbWorkInterrupted(e.getMessage());
		}
	}

	public abstract void work() throws Exception;
	
	void startTransanction() throws Exception
	{
		con.setAutoCommit(false);
	}
	
	public void execute() {
		try{
			startTransanction();
			work();
			endTransaction();
		}catch(Exception e){
			rollBackTransaction();
			throw new DbWorkInterrupted(e.getMessage());
		}
		
		
	}
	
	void endTransaction() throws Exception{
		con.commit();
		con.setAutoCommit(true);
		con.close();
		con = null;
		
	}
	
	void rollBackTransaction() {
		try{
			con.rollback();
			con.close();
			con = null;
		}catch(Exception e){
			
		}
	}

}
