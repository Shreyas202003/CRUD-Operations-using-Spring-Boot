package com.book.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "auther_autherid", referencedColumnName = "autherid")
	private Auther auther;
	
}
