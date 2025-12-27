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
@Table(name="Auther")
public class Auther {

	@Column(name="authername")
	private String authNm;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="autherid")
	private int authId;
	
}
