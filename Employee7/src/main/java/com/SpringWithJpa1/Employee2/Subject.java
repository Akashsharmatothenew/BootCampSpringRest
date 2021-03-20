package com.SpringWithJpa1.Employee2;

import javax.persistence.*;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "subjectname")
    private String subjectName;

    @ManyToOne
    @JoinColumn(name = "authorsubjectid",referencedColumnName = "id")
    private Author author;

    public Subject() {
    }

    public Subject(int id, String subjectName, Author author) {
        this.id = id;
        this.subjectName = subjectName;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
