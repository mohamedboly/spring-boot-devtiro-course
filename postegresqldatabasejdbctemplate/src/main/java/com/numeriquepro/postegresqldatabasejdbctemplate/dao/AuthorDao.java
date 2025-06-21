package com.numeriquepro.postegresqldatabasejdbctemplate.dao;

import com.numeriquepro.postegresqldatabasejdbctemplate.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long authorId);
}
