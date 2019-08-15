package db.unitofwork;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

class UnitOfWorkDummy extends UnitOfWork{
	public void work() throws DbWorkInterrupted{
		
	}
};


public class UnitOfWorkShould {
	
	@Test(expected = DbWorkInterrupted.class)
	public void throw_DBWorkInterrupted_Exception() throws Exception{
		UnitOfWorkDummy dummy = spy(UnitOfWorkDummy.class);
		Mockito.doThrow(new DbWorkInterrupted("")).when(dummy).work();
		dummy.execute();
		verify(dummy).execute();
		verify(dummy).startTransanction();
		verify(dummy).work();
		verify(dummy).rollBackTransaction();
		verify(dummy, never()).endTransaction();
	}
	
	@Test
	public void execute_temmplate_and_verify() throws Exception{
		UnitOfWorkDummy dummy = spy(UnitOfWorkDummy.class);
		dummy.execute();
		verify(dummy).execute();
		verify(dummy).startTransanction();
		verify(dummy).work();
		verify(dummy).endTransaction();
		verify(dummy, never()).rollBackTransaction();
	}


}
