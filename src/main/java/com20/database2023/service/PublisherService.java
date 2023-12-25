package com20.database2023.service;

import com20.database2023.dto.request.PublisherRequest;
import com20.database2023.dto.response.PublisherResponse;
import com20.database2023.dto.response.SimpleResponse;
import com20.database2023.entity.Book;

import java.util.List;

public interface PublisherService {

    void insert(PublisherRequest publisherRequest);

    List<PublisherResponse> getAll();

    void update(Long id, PublisherRequest publisherRequest);

    void delete(Long id);

    SimpleResponse setBooks(List<Book> books,Long publishersId);
}
