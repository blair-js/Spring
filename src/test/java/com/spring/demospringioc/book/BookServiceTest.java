package com.spring.demospringioc.book;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @Test
    public void save() {

        Book book = new Book();

        //save 메소드 호출시 book 객체가 들어오면 book을 반환하라는 의미이다.
        when(bookRepository.save(book)).thenReturn(book);

        //BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository);

        Book result = bookService.save(book);

        assertThat(book.getCreated()).isNotNull();
        assertThat(book.getBookStatus()).isEqualTo(BookStatus.DRAFT);
        assertThat(result).isNotNull();

    }
}