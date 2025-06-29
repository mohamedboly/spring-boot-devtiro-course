package com.numeriquepro.postegresqldatabasejdbctemplate.dao.impl;

import com.numeriquepro.postegresqldatabasejdbctemplate.dao.BookDao;
import com.numeriquepro.postegresqldatabasejdbctemplate.domain.Author;
import com.numeriquepro.postegresqldatabasejdbctemplate.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Optional;

public class BookDaoImpl implements BookDao {
     private final JdbcTemplate jdbcTemplate;

     public BookDaoImpl(JdbcTemplate jdbcTemplate) {
         this.jdbcTemplate = jdbcTemplate;
     }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)",
                book.getIsbn(), book.getTitle(), book.getAuthorId());
    }

    @Override
    public Optional<Book> findOne(String isbn) {
        List<Book> results = jdbcTemplate.query(
                "SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1",
                new BookRowMapper(), isbn
        );

        return results.stream().findFirst();
    }

    public class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            return Book.builder()
                    .isbn(rs.getString("isbn"))
                    .title(rs.getString("title"))
                    .authorId(rs.getLong("author_id"))
                    .build();
        }
    }
}
