package com20.database2023.service.impl;

import com20.database2023.dao.PublisherDao;
import com20.database2023.dto.request.PublisherRequest;
import com20.database2023.dto.response.PublisherResponse;
import com20.database2023.dto.response.SimpleResponse;
import com20.database2023.entity.Book;
import com20.database2023.entity.Publisher;
import com20.database2023.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherDao publisherDao;
    private final PublisherService publisherService;


    @Override
    public void insert(PublisherRequest publisherRequest) {
        Publisher publisher = new Publisher();
        publisherDao.insert(publisher);
    }

    @Override
    public List<PublisherResponse> getAll() {
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

    @Override
    public SimpleResponse setBooks(List<Book> books,Long publishersId){
        PublisherResponse publisher = publisherDao.findPublisherById(publishersId);
        if (publisher.equals(null)){
            try {
                throw new BadRequestException("There are no any publishers with this ID");
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        }
        publisher.setBooks(books);
        publisherService.setBooks(books, publishersId);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Books are successfully published !!!")
                .build();
    }
}
