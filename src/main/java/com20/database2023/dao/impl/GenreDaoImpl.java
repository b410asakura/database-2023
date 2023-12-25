package com20.database2023.dao.impl;

import com20.database2023.dao.GenreDao;
import com20.database2023.dto.response.AuthorResponse;
import com20.database2023.entity.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GenreDaoImpl implements GenreDao {


    @Override
    public void insert(Genre genre) {

    }

    @Override
    public List<AuthorResponse> getAll() {
        return null;
    }

    @Override
    public void update(Long id, Genre genre) {

    }

    @Override
    public void delete(Long id) {

    }
}
