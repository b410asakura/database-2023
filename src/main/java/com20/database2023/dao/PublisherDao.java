package com20.database2023.dao;

import com20.database2023.dto.response.PublisherResponse;
import com20.database2023.entity.Publisher;
import java.util.List;

public interface PublisherDao {


    void insert(Publisher publisher);

    List<PublisherResponse> getAll();

    void update(Long id, Publisher publisher);

    void delete(Long id);

    PublisherResponse findPublisherById(Long publishersId);
}
