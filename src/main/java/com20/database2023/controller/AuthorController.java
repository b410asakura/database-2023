package com20.database2023.controller;

import com20.database2023.dto.request.AuthorRequest;
import com20.database2023.dto.response.AuthorResponse;
import com20.database2023.dto.response.SimpleResponse;
import com20.database2023.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/insert")
    SimpleResponse insert(@RequestBody AuthorRequest authorRequest) {
        authorService.insert(authorRequest);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Author saved")
                .build();
    }

    @GetMapping
    List<AuthorResponse> getAll() {
        return authorService.getAll();
    }

    @PutMapping
    void update(@RequestParam Long id, @RequestBody AuthorRequest authorRequest) {
        authorService.update(id, authorRequest);
    }

    @DeleteMapping
    void delete(@RequestParam Long id) {
        authorService.delete(id);
    }
}
