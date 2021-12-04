package com.startup.startupwebapp.bootstrap;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.startup.startupwebapp.domain.Author;
import com.startup.startupwebapp.domain.Book;
import com.startup.startupwebapp.repositories.AuthorRepository;
import com.startup.startupwebapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain driven Design", "10001");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod = new Author("Rod", "Johnson");
        Book ejb = new Book("j2EE dev", "123123");

        rod.getBooks().add(ejb);
        ejb.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(ejb);

        System.out.println("Started Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());

    }
}
