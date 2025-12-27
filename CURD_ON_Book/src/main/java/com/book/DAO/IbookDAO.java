package com.book.DAO;

import java.util.List;

import com.book.entity.book;

public interface IbookDAO{
	public void addBook(book b);
	public List<book> displayAll();
	public void deleteBook(int id);
	public void updateBook(String bname, int publishyear, int id);
}
