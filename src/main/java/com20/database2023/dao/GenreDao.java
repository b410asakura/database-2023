package com20.database2023.dao;

import com20.database2023.dto.response.GenreResponse;
import com20.database2023.entity.Genre;

import java.util.List;

public interface GenreDao {


    void insert(Genre genre);

    List<GenreResponse> getAll();

    void update(Long id, Genre genre);

    void delete(Long id);

    Genre findById(Long id);
}
