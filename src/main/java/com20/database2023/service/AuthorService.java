package com20.database2023.service;

import com20.database2023.dto.request.AuthorRequest;
import com20.database2023.dto.response.AuthorResponse;

import java.util.List;

public interface AuthorService {


    void insert(AuthorRequest authorRequest);

    List<AuthorResponse> getAll();

    void update(Long id, AuthorRequest authorRequest);

    void delete(Long id);
}
