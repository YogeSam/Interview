package com.book.entity;

import com.google.gson.annotations.Expose;

import jsonannotation.JSONSerializable;
import jsonannotation.SerializeToJson;
import validateoutputannotation.ValidateOutput;
import validateoutputannotation.ValidateWholeNumber;

@JSONSerializable
@ValidateOutput
public class BookEntity {
	@Expose
	@ValidateWholeNumber(min=1, max=10)
	String bookId;
	@Expose
	String bookName;
	@Expose
	String authorName;
	
	public BookEntity(String bookId, String bookName, String authorName) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	@Override
	public String toString() {
		return new SerializeToJson().serialize(this);
	}
	
}
