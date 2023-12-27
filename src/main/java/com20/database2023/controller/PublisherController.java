package com20.database2023.controller;

import com20.database2023.dto.request.PublisherRequest;
import com20.database2023.dto.response.PublisherResponse;
import com20.database2023.dto.response.SimpleResponse;
import com20.database2023.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/publisher")
public class PublisherController {

    private final PublisherService publisherService;


    @PostMapping("/insert")
    SimpleResponse insert(@RequestBody PublisherRequest publisherRequest) {
        publisherService.insert(publisherRequest);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Publisher is successfully saved !!!")
                .build();
    }

    @GetMapping
    List<PublisherResponse> getAll() {
        return publisherService.getAll();
    }

    @PutMapping
    SimpleResponse update(@RequestParam Long id, @RequestBody PublisherRequest publisherRequest) {
        publisherService.update(id, publisherRequest);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Publisher is successfully updated !!!")
                .build();
    }

    @DeleteMapping
    SimpleResponse delete(@RequestParam Long id) {
        publisherService.delete(id);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Publisher is successfully deleted !!!")
                .build();
    }

//    @PostMapping
//    SimpleResponse setBooks(@RequestBody List<Book>books, @RequestParam Long id){
//        publisherService.setBooks(books, id);
//        return SimpleResponse.builder()
//                .httpStatus(HttpStatus.OK)
//                .message("Books are successfully published !!!")
//                .build();
//    }
}