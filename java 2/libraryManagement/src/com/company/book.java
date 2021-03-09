package com.company;

import java.util.Date;

/**
 * Created by ttn on 17/2/21.
 */

    abstract class Book {
    private String title;
    private String subject;
    private String publisher;
    private String language;
}
class BookItem extends Book {
    private String barcode;
    private boolean isReferenceOnly;
    private Date borrowed;
    private Date dueDate;
    private double price;
    private BookStatus status;
    private Date dateOfPurchase;
    private Date publicationDate;

    public void checkout(String memberId) {
        boolean getIsReferenceOnly = false;
        if (getIsReferenceOnly != false) {
            System.out.println("This book is Reference only and can't be issued");
        } else {
            System.out.println("checkout Susessfully");
        }
    }
}
