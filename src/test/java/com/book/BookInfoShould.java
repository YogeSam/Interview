package com.book;

import static org.mockito.Mockito.*;
import org.junit.Test;

import com.book.entity.BookEntity;
import com.book.service.BookNotFoundExcpeption;
import com.book.service.BookService;

public class BookInfoShould {

	@Test(expected = BookNotFoundExcpeption.class)
	public void throwBookNotFoundException() {
		BookInfo bookinfo = new BookInfo();
		BookService bookService = mock(BookService.class);
		when(bookService.findBook(-1)).thenThrow(new BookNotFoundExcpeption("Book Not Found."));
		bookinfo.findBook(bookService, -1);
	}
	
	@Test
	public void returnJSONBookObjectGivenValidBookId(){
		BookInfo bookinfo = new BookInfo();
		BookService bookService = mock(BookService.class);
		when(bookService.findBook(1)).thenReturn(new BookEntity("1","Test Book", "Test Author"));
		String bookJson = bookinfo.findBook(bookService, 1);
		System.out.println(bookJson);
		verify(bookService).findBook(1);
		assert(bookJson.indexOf("Test Book") >= 0 && bookJson.indexOf("Test Author") >= 0 );
	}

}
