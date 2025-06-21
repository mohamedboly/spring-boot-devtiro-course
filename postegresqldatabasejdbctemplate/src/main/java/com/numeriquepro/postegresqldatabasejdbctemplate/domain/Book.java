package com.numeriquepro.postegresqldatabasejdbctemplate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private Long authorId;
    private String title;
    private String isbn;
}
