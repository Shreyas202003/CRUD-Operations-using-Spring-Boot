package com.book.service;

import java.util.List;

import com.book.entity.book;

public interface IbookService {
	public void addBook(book b);
	public List<book> displayAll();
	public void deleteBook(int id);
	public void  updateBook(book b, int id);
}
