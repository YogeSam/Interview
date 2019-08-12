package com.book;

import static org.mockito.Mockito.*;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import com.book.entity.BookEntity;
import com.book.service.BookNotFoundExcpeption;
import com.book.service.BookService;

public class BookInfoShould {
	final BookEntity bookEntity = new BookEntity("1","Test Book", "Test Author");
	final String bookDetailJson = "{\"bookId\":\"1\",\"bookName\":\"Test Book\",\"authorName\":\"Test Author\"}";
	final String bookIdJson = "{\"bookId\" : \"1\" }";
	
	@Test(expected = BookNotFoundExcpeption.class)
	public void throwBookNotFoundException() {
		BookInfo bookinfo = new BookInfo();
		BookService bookService = mock(BookService.class);
		when(bookService.findBook(-1)).thenThrow(new BookNotFoundExcpeption("Book Not Found."));
		bookinfo.findBook(bookService, -1);
	}
	
	@Test
	public void returnJSONBookObjectGivenValidBookId() throws JSONException{
		BookInfo bookinfo = new BookInfo();
		BookService bookService = mock(BookService.class);
		when(bookService.findBook(1)).thenReturn(bookEntity);

		String bookJson = bookinfo.findBook(bookService, 1);
		
		verify(bookService).findBook(1);

		JSONAssert.assertEquals(bookIdJson, bookJson, false);
		JSONAssert.assertEquals(bookDetailJson, bookJson, true); 		
	}

}
