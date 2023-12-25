package com20.database2023.dao.impl;

import com20.database2023.dao.BookDao;
import com20.database2023.dto.response.AuthorResponse;
import com20.database2023.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {
    private final JdbcTemplate jdbcTemplate;


    @Override
    public void insert(Book book) {

    }

    @Override
    public List<AuthorResponse> getAll() {
        return null;
    }

    @Override
    public void update(Long id, Book book) {

    }

    @Override
    public void delete(Long id) {

    }
}
