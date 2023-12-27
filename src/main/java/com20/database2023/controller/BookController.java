package com20.database2023.controller;

import com20.database2023.dto.request.BookRequest;
import com20.database2023.dto.response.BookResponse;
import com20.database2023.dto.response.SimpleResponse;
import com20.database2023.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    @PostMapping("/insert")
    SimpleResponse insert(@RequestBody BookRequest bookRequest) {
        bookService.insert(bookRequest);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("book was saved")
                .build();
    }

    @GetMapping
    List<BookResponse> getAll() {
        return bookService.getAll();
    }

    @PutMapping
    SimpleResponse update(@RequestParam Long id, @RequestBody BookRequest bookRequest) {
        bookService.update(id, bookRequest);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("book was updated")
                .build();
    }

    @DeleteMapping
    SimpleResponse delete(@RequestParam Long id) {
        bookService.delete(id);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("book was deleted")
                .build();
    }

    @PostMapping("/relationBookGenre")
    SimpleResponse addRelationBookGenre(@RequestParam Long bookId, @RequestParam Long genreId) {
        bookService.addRelationBookGenre(bookId, genreId);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("relation book id " + bookId + " genre id " + genreId)
                .build();
    }

    @PostMapping("/relationBookPublisher")
    SimpleResponse addRelationBookPublisher(@RequestParam Long bookId, @RequestParam Long publisherId) {
        bookService.addRelationBookPublisher(bookId, publisherId);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("relation book id " + bookId + " publisher id " + publisherId)
                .build();
    }

    @GetMapping("/getAllBooksByAuthor")
    List<BookResponse> getAllBooksByAuthor(@RequestParam Long authorId) {
        return bookService.getAllBooksByAuthor(authorId);
    }

    @GetMapping("/getAllBooksByAuthorGenre")
    List<BookResponse> getAllBooksByGenre(@RequestParam Long genreId) {
        return bookService.getAllBooksByGenre(genreId);
    }

}
