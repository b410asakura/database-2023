package com20.database2023.controller;

import com20.database2023.dto.request.GenreRequest;
import com20.database2023.dto.response.AuthorResponse;
import com20.database2023.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/genre")
public class GenreController {

    private final GenreService genreService;



    @PostMapping("/insert")
    void insert(@RequestBody GenreRequest genreRequest) {
        genreService.insert(genreRequest);
    }

    @GetMapping
    List<AuthorResponse> getAll() {
        return genreService.getAll();
    }

    @PutMapping
    void update(@RequestParam Long id, @RequestBody GenreRequest genreRequest) {
        genreService.update(id, genreRequest);
    }

    @DeleteMapping
    void delete(@RequestParam Long id) {
        genreService.delete(id);
    }
}
