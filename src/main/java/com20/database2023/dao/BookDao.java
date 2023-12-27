package com20.database2023.dao;

import com20.database2023.dto.response.BookResponse;
import com20.database2023.entity.Book;

import java.util.List;

public interface BookDao {


    void insert(Book book);

    List<BookResponse> getAll();

    void update(Long id, Book book);

    void delete(Long id);

    void addRelationBookPublisher(Long bookId, Long publisherId);

    void addRelationBookGenre(Long bookId, Long genreId);

    List<BookResponse> getAllByGenre(Long genreId);

    List<BookResponse> getAllByAuthor(Long authorId);
}
