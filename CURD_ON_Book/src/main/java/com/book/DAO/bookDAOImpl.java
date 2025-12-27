package com.book.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.Repo.BookRepository;
import com.book.entity.book;

@Component
public class bookDAOImpl implements IbookDAO {
	
	@Autowired
	BookRepository bRepo;

	@Override
	public void addBook(book b) {
		bRepo.save(b);
	}

	@Override
	public List<book> displayAll() {
		List<book> book = new ArrayList<>();
		book = bRepo.findAll();
		return book;
	}

	@Override
	public void deleteBook(int id) {
		bRepo.deleteById(id);
	}

	@Override
	public void updateBook(String bname, int publishyear, int id) {
		bRepo.updateBk(bname, publishyear, id);
	}

}
