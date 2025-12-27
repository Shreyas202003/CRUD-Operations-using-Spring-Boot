package com.book.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.Repo.BookRepository;
import com.book.Repo.autherRepo;
import com.book.entity.Auther;
import com.book.entity.book;

@Component
public class bookDAOImpl implements IbookDAO {
	
	@Autowired
	BookRepository bRepo;
	
	@Autowired
	autherRepo auth;

	@Override
	public void addBook(book b) {
//		Auther a1 = b.getAuther();
//		Optional<Auther> a = auth.findById(a1.getAuthId());
//		if(a.isPresent()) {
//			Auther ath =a.get();
//			b.setAuther(ath);
//		}
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
