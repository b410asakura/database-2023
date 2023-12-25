package com20.database2023.service;

import com20.database2023.dto.request.GenreRequest;
import com20.database2023.dto.response.GenreResponse;
import java.util.List;

public interface GenreService {

    void insert(GenreRequest genreRequest);

    List<GenreResponse> getAll();

    void update(Long id, GenreRequest genreRequest);

    void delete(Long id);
}
