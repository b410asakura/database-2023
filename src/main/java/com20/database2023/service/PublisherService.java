package com20.database2023.service;

import com20.database2023.dto.request.PublisherRequest;
import com20.database2023.dto.response.AuthorResponse;

import java.util.List;

public interface PublisherService {

    void insert(PublisherRequest publisherRequest);

    List<AuthorResponse> getAll();

    void update(Long id, PublisherRequest publisherRequest);

    void delete(Long id);
}
