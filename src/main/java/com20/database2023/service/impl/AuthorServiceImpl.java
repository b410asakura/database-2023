package com20.database2023.service.impl;

import com20.database2023.dao.AuthorDao;
import com20.database2023.dto.request.AuthorRequest;
import com20.database2023.dto.response.AuthorResponse;
import com20.database2023.entity.Author;
import com20.database2023.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;

    @Override
    public void insert(AuthorRequest authorRequest) {
        Author author = new Author();
        author.setName(authorRequest.getName());
        author.setEmail(authorRequest.getEmail());
        authorDao.insert(author);
    }

    @Override
    public List<AuthorResponse> getAll() {
        return authorDao.getAll();
    }

    @Override
    public void update(Long id, AuthorRequest authorRequest) {
        Author author = new Author();
        author.setName(authorRequest.getName());
        author.setEmail(authorRequest.getEmail());
        authorDao.update(id, author);
    }

    @Override
    public void delete(Long id) {
        authorDao.delete(id);
    }
}
