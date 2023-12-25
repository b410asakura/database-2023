package com20.database2023.controller;

import com20.database2023.dto.request.GenreRequest;
import com20.database2023.dto.response.GenreResponse;
import com20.database2023.dto.response.SimpleResponse;
import com20.database2023.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/genre")
public class GenreController {

    private final GenreService genreService;

    @PostMapping("/insert")
    SimpleResponse insert(@RequestBody GenreRequest genreRequest) {
        genreService.insert(genreRequest);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Genre was saved")
                .build();
    }

    @GetMapping
    List<GenreResponse> getAll() {
        return genreService.getAll();
    }

    @PutMapping
    SimpleResponse update(@RequestParam Long id, @RequestBody GenreRequest genreRequest) {
        genreService.update(id, genreRequest);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Genre was updated")
                .build();
    }

    @DeleteMapping
    SimpleResponse delete(@RequestParam Long id) {
        genreService.delete(id);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Genre was deleted")
                .build();
    }
}