package com.book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="bookdetails")
public class book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bid")
	private int bookid;
	
	@Column(name="bname")
	private String bname;
	
	@Column(name="publishyear")
	private int publishDate;
	
}
