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
		return bookService.findBook(bookid).toString();
	}

	public BookEntity update(BookService bookService, BookEntity bookEntity) {
		return bookService.update(bookEntity);
	}  
	
	public BookEntity update(BookEntity bookEntity) {
		return update(new BookServiceImpl(), bookEntity);
	}  

}
