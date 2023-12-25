package com20.database2023.service;

import com20.database2023.dto.request.BookRequest;
import com20.database2023.dto.response.AuthorResponse;

import java.util.List;

public interface BookService {


    void insert(BookRequest bookRequest);

    List<AuthorResponse> getAll();

    void update(Long id, BookRequest bookRequest);

    void delete(Long id);
}
