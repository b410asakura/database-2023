package com20.database2023.service.impl;

import com20.database2023.dao.PublisherDao;
import com20.database2023.dto.request.PublisherRequest;
import com20.database2023.dto.response.AuthorResponse;
import com20.database2023.entity.Publisher;
import com20.database2023.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherDao publisherDao;


    @Override
    public void insert(PublisherRequest publisherRequest) {
        Publisher publisher = new Publisher();
        publisherDao.insert(publisher);
    }

    @Override
    public List<AuthorResponse> getAll() {
        return publisherDao.getAll();
    }

    @Override
    public void update(Long id, PublisherRequest publisherRequest) {
        Publisher publisher = new Publisher();
        publisherDao.update(id, publisher);
    }

    @Override
    public void delete(Long id) {
        publisherDao.delete(id);
    }
}
