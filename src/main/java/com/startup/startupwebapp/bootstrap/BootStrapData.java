package com.startup.startupwebapp.bootstrap;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.startup.startupwebapp.domain.Author;
import com.startup.startupwebapp.domain.Book;
import com.startup.startupwebapp.domain.Publisher;
import com.startup.startupwebapp.repositories.AuthorRepository;
import com.startup.startupwebapp.repositories.BookRepository;
import com.startup.startupwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher pub = new Publisher();
        pub.setName("pubName");
        pub.setAddress("addressline");
        publisherRepository.save(pub);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain driven Design", "10001");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(pub);
        pub.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(pub);


        Author rod = new Author("Rod", "Johnson");
        Book ejb = new Book("j2EE dev", "123123");
        rod.getBooks().add(ejb);
        ejb.getAuthors().add(rod);

        ejb.setPublisher(pub);
        pub.getBooks().add(ejb);
        authorRepository.save(rod);
        bookRepository.save(ejb);
        publisherRepository.save(pub);


        System.out.println("Started Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of pubs: " + publisherRepository.count());
        System.out.println("Publisher num of books: " + pub.getBooks().size());
    }
}
