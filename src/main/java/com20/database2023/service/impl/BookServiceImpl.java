package com20.database2023.service.impl;

import com20.database2023.dao.BookDao;
import com20.database2023.dto.request.BookRequest;
import com20.database2023.dto.response.AuthorResponse;
import com20.database2023.entity.Book;
import com20.database2023.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;


    @Override
    public void insert(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        bookDao.insert(book);
    }

    @Override
    public List<AuthorResponse> getAll() {
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
}
