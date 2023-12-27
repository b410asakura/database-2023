package com20.database2023.service.impl;

import com20.database2023.dao.AuthorDao;
import com20.database2023.dao.BookDao;
import com20.database2023.dto.request.BookRequest;
import com20.database2023.dto.response.BookResponse;
import com20.database2023.entity.Book;
import com20.database2023.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;
    private final AuthorDao authorDao;


    @Override
    public void insert(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setPublicationYear(bookRequest.getPublicationYear());
        book.setAuthor(authorDao.findById(bookRequest.getAuthorId()));
        bookDao.insert(book);
    }

    @Override
    public List<BookResponse> getAll() {
        return bookDao.getAll();
    }

    @Override
    public void update(Long id, BookRequest bookRequest) {
        Book book = new Book();
        bookDao.update(id, book);
    }

    @Override
    public void delete(Long id) {
        bookDao.delete(id);
    }

    @Override
    public void addRelationBookGenre(Long bookId, Long genreId) {
        bookDao.addRelationBookGenre(bookId, genreId);
    }

    @Override
    public void addRelationBookPublisher(Long bookId, Long publisherId) {
        bookDao.addRelationBookPublisher(bookId, publisherId);
    }

    @Override
    public List<BookResponse> getAllBooksByAuthor(Long authorId) {
        return bookDao.getAllByAuthor(authorId);
    }

    @Override
    public List<BookResponse> getAllBooksByGenre(Long genreId) {
        return bookDao.getAllByGenre(genreId);
    }
}
