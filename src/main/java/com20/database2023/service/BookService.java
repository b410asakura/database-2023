package com20.database2023.service;

import com20.database2023.dto.request.BookRequest;
import com20.database2023.dto.response.BookResponse;

import java.util.List;

public interface BookService {


    void insert(BookRequest bookRequest);

    List<BookResponse> getAll();

    void update(Long id, BookRequest bookRequest);

    void delete(Long id);

    void addRelationBookGenre(Long bookId, Long genreId);

    void addRelationBookPublisher(Long bookId, Long publisherId);

    List<BookResponse> getAllBooksByAuthor(Long authorId);

    List<BookResponse> getAllBooksByGenre(Long genreId);
}
