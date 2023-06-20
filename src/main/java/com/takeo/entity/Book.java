package com.takeo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="BOOK")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BOOKID")
	private Integer bookId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="AUTHOR")
	private String author;
	
	@Column(name="PUBLICATIONYEAR")
	private  Integer publicationYear;
	
	@Column(name="ISBN")
	private Integer isbn;

}
