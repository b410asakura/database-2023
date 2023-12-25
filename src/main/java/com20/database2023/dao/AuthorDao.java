package com20.database2023.dao;

import com20.database2023.dto.response.AuthorBookResponse;
import com20.database2023.dto.response.AuthorResponse;
import com20.database2023.entity.Author;

import java.util.List;

public interface AuthorDao {


    void insert(Author author);

    List<AuthorResponse> getAll();

    void update(Long id, Author author);

    void delete(Long id);

    AuthorBookResponse getAuthorBooks(Long id);
}
