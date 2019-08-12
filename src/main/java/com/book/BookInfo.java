package com.book;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

import com.book.entity.BookEntity;
import com.book.service.BookService;
import com.book.service.BookServiceImpl;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dbConnection.DbConnection;
import jsonannotation.SerializeToJson;

public class BookInfo {
	
	
	public String findBook(int bookid){
		return findBook(new BookServiceImpl(), bookid);
	}
	
	public String findBook(BookService bookService, int bookid) {
		/*String result = "";
		JsonObject bookInfo = new JsonObject();
		JsonArray bookList = new JsonArray();
		bookInfo.add("books", bookList);*/
		
		return bookService.findBook(bookid).toString();
		/*JsonObject bookjsonobj = new JsonObject();
		bookjsonobj.addProperty("bookid", bookenity.getBookId());
		bookjsonobj.addProperty("bookname", bookenity.getBookName());
		bookjsonobj.addProperty("authorname", bookenity.getAuthorName());
		bookList.add(bookjsonobj);
		*/
		
		//Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		//result  = gson.toJson(bookInfo);
		
		//return bookenity.toString();
		
	}  

	
	/*public String findAllBooks(){
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
	*/
	
	
	public static void main(String args[]){  
		BookInfo book = new BookInfo();
		System.out.println(book.findBook(280));
	}


}
