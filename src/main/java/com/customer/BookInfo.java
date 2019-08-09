package com.customer;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dbConnection.DbConnection;

public class BookInfo {
	
	
	public String findBook(int bookid){
		String result = "";
		try{  
		Connection con = DbConnection.getConnection();  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select Id, bookname, authorname from book where id = " + bookid);
		
		JsonObject bookInfo = new JsonObject();
		JsonArray bookList = new JsonArray();
		bookInfo.add("books", bookList);
		if(rs.next()){  
			String bookId = rs.getString("Id");
			String bookName = rs.getString("bookname");
			String authorName = rs.getString("authorname");
			
			JsonObject book = new JsonObject();
			book.addProperty("bookid", bookId);
			book.addProperty("bookname", bookName);
			book.addProperty("authorname", authorName);
			
			bookList.add(book);
		}
		
		if(bookList.size() < 0){
			throw new Exception("No books found");
		}

		rs.close();
		stmt.close();
		con.close();  
		
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		result  = gson.toJson(bookInfo);
		}catch(Exception e){ 
			System.out.println(e);
		}  
		return result;		
	}
	
	public String findAllBooks(){
		String result = "";
		try{  
		Connection con = DbConnection.getConnection();  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select Id, bookname, authorname from book");
		
		JsonObject bookInfo = new JsonObject();
		JsonArray bookList = new JsonArray();
		bookInfo.add("books", bookList);
		while(rs.next()){  
			
			String bookId = rs.getString("Id");
			String bookName = rs.getString("bookname");
			String authorName = rs.getString("authorname");
			
			JsonObject book = new JsonObject();
			book.addProperty("bookid", bookId);
			book.addProperty("bookname", bookName);
			book.addProperty("authorname", authorName);
			
			bookList.add(book);
			
			//System.out.println(bookId +"  "+ bookName +"  "+ authorName);
		}
		
		if(bookList.size() < 0){
			throw new Exception("No books found");
		}

		rs.close();
		stmt.close();
		con.close();  
		
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		result  = gson.toJson(bookInfo);
		
		
		
		}catch(Exception e){ 
			System.out.println(e);
		}  
		
		return result;
	}
	
	
	
	public static void main(String args[]){  
		BookInfo book = new BookInfo();
		System.out.println(book.findBook(-1));
	}  

}
