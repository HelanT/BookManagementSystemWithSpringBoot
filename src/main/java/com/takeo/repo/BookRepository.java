package com.takeo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.takeo.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

}
