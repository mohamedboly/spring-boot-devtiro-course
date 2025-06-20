package com.numeriquepro.postegresqldatabasejdbctemplate.dao;

import com.numeriquepro.postegresqldatabasejdbctemplate.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> findOne(String isbn);
}
