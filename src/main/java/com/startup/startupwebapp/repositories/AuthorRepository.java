package com.startup.startupwebapp.repositories;

import com.startup.startupwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;


public interface AuthorRepository extends CrudRepository<Author, Long> {
}
