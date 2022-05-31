package com.spring.demospringioc.book;

import java.util.Date;

public class Book {

    private Date created;

    private  BookStatus bookStatus;

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
