package com.startup.startupwebapp.repositories;

import com.startup.startupwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
