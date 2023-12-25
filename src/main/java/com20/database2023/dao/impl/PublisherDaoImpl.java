package com20.database2023.dao.impl;

import com20.database2023.dao.PublisherDao;
import com20.database2023.dto.response.AuthorResponse;
import com20.database2023.entity.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PublisherDaoImpl implements PublisherDao {

    private final JdbcTemplate jdbcTemplate;


    @Override
    public void insert(Publisher publisher) {

    }

    @Override
    public List<AuthorResponse> getAll() {
        return null;
    }

    @Override
    public void update(Long id, Publisher publisher) {

    }

    @Override
    public void delete(Long id) {

    }
}
