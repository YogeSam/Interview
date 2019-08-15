package com.book;

import static org.mockito.Mockito.*;

import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import com.book.entity.BookEntity;
import com.book.service.BookNotFoundExcpeption;
import com.book.service.BookService;
import com.book.service.BookServiceImpl;
import com.book.service.ConcurrencyViolation;

public class BookInfoShould {
	final BookEntity bookEntity = new BookEntity("1","Test Book", "Test Author");
	final String bookDetailJson = "{\"bookId\":\"1\",\"bookName\":\"Test Book\",\"authorName\":\"Test Author\"}";
	final String bookIdJson = "{\"bookId\" : \"1\" }";
	BookInfo bookinfo;  
	BookService bookService;
	
	@Before
	public void setup(){
		bookinfo = new BookInfo();
		bookService = mock(BookService.class);
	}
	
	@Test(expected = BookNotFoundExcpeption.class)
	public void throwBookNotFoundException() {
		when(bookService.findBook(-1)).thenThrow(new BookNotFoundExcpeption("Book Not Found."));
		bookinfo.findBook(bookService, -1);
	}
	
	@Test
	public void returnJSONBookObjectGivenValidBookId() throws JSONException{
		when(bookService.findBook(1)).thenReturn(bookEntity);

		String bookJson = bookinfo.findBook(bookService, 1);
		
		verify(bookService).findBook(1);

		JSONAssert.assertEquals(bookIdJson, bookJson, false);
		JSONAssert.assertEquals(bookDetailJson, bookJson, true); 		
	}
	
	@Test 
	public void updateBook(){
		when(bookService.update(bookEntity)).thenReturn(bookEntity);
		bookinfo.update(bookService, bookEntity);
		verify(bookService).update(bookEntity);
	}
	
	@Test (expected = ConcurrencyViolation.class)	
	public void throw_concurrencyviolation_when_staleupdate(){
		when(bookService.update(bookEntity)).thenThrow(new ConcurrencyViolation("Incorrect update on a stale book object."));
		bookinfo.update(bookService, bookEntity);
		verify(bookService).update(bookEntity);
	}
	

	//Perform an end to end test or integration test
	@Test 
	@Ignore
	public void throw_concurrencyviolation_when_staleupdate_endtoend(){
		//User 1
		BookInfo bookinfo_user1 = new BookInfo();
		BookEntity book_byuser1 = new BookServiceImpl().findBook(280);
		book_byuser1.setBookName("New  BookName231");
		
		//User 2
		BookInfo bookinfo_user2 = new BookInfo();
		BookEntity book_byuser2 = new BookServiceImpl().findBook(280);
		book_byuser2.setAuthorName("New AuthorName321");
		
		//Update the book first by user2 
		//Now update by user1 should throw ConcurrencyViolation exception 
		bookinfo_user2.update(book_byuser2);
		
		delayInSeconds(2);
		
		try{
			bookinfo_user1.update(book_byuser1);
			Assert.assertFalse("Unreachable code",false);
		}catch(ConcurrencyViolation e){
			Assert.assertTrue(true);
		}
		
	}
	
	
	//Perform an end to end test or integration test
	
	@Test 	
	
	public void update_endtoend(){
		//User 1
		BookInfo bookinfo_user1 = new BookInfo();
		BookEntity book_byuser1 = new BookServiceImpl().findBook(280);
		book_byuser1.setBookName("New  BookName123");
		bookinfo_user1.update(book_byuser1);
		
		delayInSeconds(2);
		
		//User 2
		BookInfo bookinfo_user2 = new BookInfo();
		BookEntity book_byuser2 = new BookServiceImpl().findBook(280);
		book_byuser2.setAuthorName("New AuthorName1");
		bookinfo_user2.update(book_byuser2);
		
		
	}

	private void delayInSeconds(int n) {
		//delay of 2 seconds
		try{
			TimeUnit.SECONDS.sleep(n);
		}catch(InterruptedException e){
			
		}
	}
	
}
