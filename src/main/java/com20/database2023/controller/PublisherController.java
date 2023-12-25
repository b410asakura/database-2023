package com20.database2023.controller;

import com20.database2023.dto.request.PublisherRequest;
import com20.database2023.dto.response.AuthorResponse;
import com20.database2023.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/publisher")
public class PublisherController {

    private final PublisherService publisherService;


    @PostMapping("/insert")
    void insert(@RequestBody PublisherRequest publisherRequest) {
        publisherService.insert(publisherRequest);
    }

    @GetMapping
    List<AuthorResponse> getAll() {
        return publisherService.getAll();
    }

    @PutMapping
    void update(@RequestParam Long id, @RequestBody PublisherRequest publisherRequest) {
        publisherService.update(id, publisherRequest);
    }

    @DeleteMapping
    void delete(@RequestParam Long id) {
        publisherService.delete(id);
    }
}
