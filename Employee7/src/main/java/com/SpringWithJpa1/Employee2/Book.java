package com.SpringWithJpa1.Employee2;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bookname")
    private String bookName;

   /* @ManyToMany
    @JoinColumn(name = "author_id")
    private List<Author> author;*/

    /*@OneToOne*/

    @ManyToOne
    @JoinColumn(name = "authorbookid",referencedColumnName = "id")
    private Author author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
