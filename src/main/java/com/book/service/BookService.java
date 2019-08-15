package com.book.service;

import com.book.entity.BookEntity;

public interface BookService {
	public BookEntity findBook(int id) ;

	public BookEntity update(BookEntity bookEntity);
}
