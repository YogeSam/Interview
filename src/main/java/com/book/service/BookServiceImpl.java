package com.book.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.book.entity.BookEntity;

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

}