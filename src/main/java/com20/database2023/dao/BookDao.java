package com20.database2023.dao;

import com20.database2023.dto.response.AuthorResponse;
import com20.database2023.entity.Book;

import java.util.List;

public interface BookDao {


    void insert(Book book);

    List<AuthorResponse> getAll();

    void update(Long id, Book book);

    void delete(Long id);
}
