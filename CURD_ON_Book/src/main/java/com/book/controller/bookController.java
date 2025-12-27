package com.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.book;
import com.book.service.IbookService;

@RestController
@RequestMapping("/book")
public class bookController {

	@Autowired
	IbookService bservice;
	
	@PostMapping("/")
	public void addController(@RequestBody book b) {
		System.out.println("adding the book");
		System.out.println(b.getBname());
		System.out.println(b.getPublishDate());
		bservice.addBook(b);
	}
	
	@GetMapping("/display")
	public ResponseEntity<List<book>> displayController(){
		List<book> list = bservice.displayAll();
		if(list.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(list));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteController(@PathVariable("id") int id) {
		try {
			bservice.deleteBook(id);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Void> updateController(@RequestBody book bk,@PathVariable("id") int id) {
		try {
			bservice.updateBook(bk, id);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
