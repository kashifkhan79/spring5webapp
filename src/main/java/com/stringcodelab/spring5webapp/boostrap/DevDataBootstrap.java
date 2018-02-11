package com.stringcodelab.spring5webapp.boostrap;

import com.stringcodelab.spring5webapp.model.Author;
import com.stringcodelab.spring5webapp.model.Book;
import com.stringcodelab.spring5webapp.model.Publisher;
import com.stringcodelab.spring5webapp.repositories.AuthorRepository;
import com.stringcodelab.spring5webapp.repositories.BookRepository;
import com.stringcodelab.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevDataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher harper = new Publisher("Harper Collins", "62-10038 155 Street, USA");
        Publisher pearson = new Publisher("Pearson", "123 Street AB, USA");

        publisherRepository.save(harper);
        publisherRepository.save(pearson);

        // Domain Driven Design by Eric Evans
        Author eric = new Author("Eric", "Evans");

        Book ddd = new Book("Domain Driven Design", "1234", harper );

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);

        bookRepository.save(ddd);

        // Absolute Java by Savich
        Author savich = new Author("Walter", "Savich");

        Book aj = new Book("Absolute Java", "7890", pearson);
        savich.getBooks().add(aj);
//        aj.getAuthors().add(savich);

        authorRepository.save(savich);
        bookRepository.save(aj);
    }
}
