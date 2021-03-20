package com.SpringWithJpa1.Employee2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author saveAuthor(Author author){/*
        List<Book> books = author.getBooks();
        for(Book book:books){
            book.setAuthor(author);
        }*/

        List<Subject> subjects = author.getSubjectSet();
        for(Subject subject:subjects){
            subject.setAuthor(author);
        }
        return authorRepository.save(author);
    }
}
