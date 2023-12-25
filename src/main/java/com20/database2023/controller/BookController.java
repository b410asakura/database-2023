package com20.database2023.controller;

import com20.database2023.dto.request.BookRequest;
import com20.database2023.dto.response.AuthorResponse;
import com20.database2023.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;



    @PostMapping("/insert")
    void insert(@RequestBody BookRequest bookRequest) {
        bookService.insert(bookRequest);
    }

    @GetMapping
    List<AuthorResponse> getAll() {
        return bookService.getAll();
    }

    @PutMapping
    void update(@RequestParam Long id, @RequestBody BookRequest bookRequest) {
        bookService.update(id, bookRequest);
    }

    @DeleteMapping
    void delete(@RequestParam Long id) {
        bookService.delete(id);
    }


}
