package com.book.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.book.entity.BookEntity;

import db.unitofwork.DbWorkInterrupted;
import db.unitofwork.UnitOfWork;
import dbConnection.DbConnection;

public class BookServiceImpl implements BookService {

	public BookEntity findBook(int id) throws BookNotFoundExcpeption {
		Connection con;   
		Statement stmt;  
		ResultSet rs;
		try{
			con = DbConnection.getConnection();  
			stmt=con.createStatement();  
			rs=stmt.executeQuery("select Id, bookname, authorname from book where id = " + id);
			if(rs.next()){
				String bookId = rs.getString("Id");
				String bookName = rs.getString("bookname");
				String authorName = rs.getString("authorname");
				return new BookEntity(bookId, bookName, authorName);
			}
			rs.close();
			stmt.close();
			con.close();

			throw new BookNotFoundExcpeption("Book with " + id + " not found. ");
			
		}catch(Exception e){
			throw new BookNotFoundExcpeption("Book with " + id + " not found. ");
		}finally{
			
		}

	}
	
	public BookEntity update(BookEntity bookEntity){
		class UpdateBook extends UnitOfWork {
				BookEntity bookEntity;
				PreparedStatement stmt;
				UpdateBook(BookEntity bookEntity) {
					super();
					this.bookEntity = bookEntity;
					try{
					stmt = createPreparedStatement();
					}catch(SQLException e){
						throw new DbWorkInterrupted(e.getMessage());
					}
				}
				
				public void work() throws Exception{
					int nUpdate = stmt.executeUpdate();
					if(nUpdate < 1)
						throw new ConcurrencyViolation("Book changes to be updated have gone stale.");
				}
				
				PreparedStatement createPreparedStatement() throws SQLException {
					String strSql = "Update book set bookname=?, authorname=?, "
							+ "modifieddatetime=NOW() where Id=? and modifieddatetime < ?";
					PreparedStatement stmt=this.con.prepareStatement(strSql);  
					stmt.setString(1, bookEntity.getBookName());
					stmt.setString(2, bookEntity.getAuthorName());
					stmt.setString(3, bookEntity.getBookId());
					stmt.setString(4,  bookEntity.getCurrentdatetime());
					return stmt;
				}
			
		}
		
		new UpdateBook(bookEntity).execute();
		return bookEntity;

	}

	/*public BookEntity update(BookEntity bookEntity) {
		Connection con = null;   
		int nUpdate = 0;
		try{
			con = DbConnection.getConnection();  
			PreparedStatement stmt = createPreparedStatement(bookEntity, con);
			con.setAutoCommit(false);
			nUpdate = stmt.executeUpdate();
			con.setAutoCommit(true);
			stmt.close();
			con.close();
		}catch(Exception e){
			rollbackTransaction(con);
			throw new RuntimeException("Book with " + bookEntity.getBookId() + " failed to update. ");
		}
		if(nUpdate < 1)
			throw new ConcurrencyViolation("Book changes to be updated have gone stale.");

		return bookEntity;
	}*/



	private void rollbackTransaction(Connection con) {
		try{
			con.rollback();
		}catch(Exception e){
			
		}
		
	}

}