package com.book.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.DAO.IbookDAO;
import com.book.entity.book;

@Service
public class bookServiceImpl implements IbookService {

	@Autowired
	IbookDAO book;
	
	book bk = new book();
	
	@Override
	public void addBook(book b) {
		
		BeanUtils.copyProperties(b, bk);
		book.addBook(bk);
	}

	@Override
	public List<book> displayAll() {
		return book.displayAll();
	}

	@Override
	public void deleteBook(int id) {
		book.deleteBook(id);
	}

	@Override
	public void updateBook(book b, int id) {
		 book.updateBook(b.getBname(),b.getPublishDate(),id);
	}

}
