package com20.database2023.service.impl;

import com20.database2023.dao.GenreDao;
import com20.database2023.dto.request.GenreRequest;
import com20.database2023.dto.response.GenreResponse;
import com20.database2023.entity.Genre;
import com20.database2023.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GenreServiceImpl implements GenreService {

    private final GenreDao genreDao;

    @Override
    public void insert(GenreRequest genreRequest) {
        Genre genre = new Genre();
        genre.setName(genreRequest.getName());
        genreDao.insert(genre);
    }

    @Override
    public List<GenreResponse> getAll() {
        return genreDao.getAll();
    }

    @Override
    public void update(Long id, GenreRequest genreRequest) {
        Genre genre = new Genre();
        genre.setName(genreRequest.getName());
        genreDao.update(id, genre);
    }

    @Override
    public void delete(Long id) {
        genreDao.delete(id);
    }
}