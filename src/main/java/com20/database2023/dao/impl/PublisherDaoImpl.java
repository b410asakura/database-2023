package com20.database2023.dao.impl;

import com20.database2023.dao.PublisherDao;
import com20.database2023.dto.response.PublisherResponse;
import com20.database2023.entity.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PublisherDaoImpl implements PublisherDao {

    private final JdbcTemplate jdbcTemplate;


    @Override
    public void insert(Publisher publisher) {
        String sql = """
                INSERT INTO publishers (name) VALUES ( ?)
                """;
        jdbcTemplate.update(sql, publisher.getName());
        System.out.println("Publisher is successfully saved !!!");
    }

    @Override
    public List<PublisherResponse> getAll() {
        String sql = """
                SELECT * FROM publishers
                """;
        return jdbcTemplate.query(sql, ((rs, rowNum) -> {
            PublisherResponse publisherResponse = new PublisherResponse();
            publisherResponse.setId(rs.getLong("id"));
            publisherResponse.setName(rs.getString("name"));
            return publisherResponse;
        }));
    }

    @Override
    public void update(Long id, Publisher publisher) {
        String sql = """ 
                UPDATE publishers SET name = ? WHERE id = ?""";
        jdbcTemplate.update(sql, publisher.getName(), id);
    }

    @Override
    public void delete(Long id) {
        String sql = """
                DELETE FROM publishers WHERE id = ?""";
        jdbcTemplate.update(sql, id);
    }

//    @Override
//    public PublisherResponse findPublisherById(Long publishersId) {
//        String sql = """
//                SELECT publisher.name FROM publisher WHERE id = ?
//                """;
//        return jdbcTemplate.queryForObject(sql, ((rs, rowNum) -> {
//            PublisherResponse publisherResponse = new PublisherResponse();
//            publisherResponse.setId(rs.getLong("id"));
//            publisherResponse.setName(rs.getString("name"));
//            return publisherResponse;
//        }));
//    }

    @Override
    public Publisher findById(Long id) {
        String sql = """
                SELECT * FROM publishers
                where publishers.id = ?
                """;
        Object[] args = {id};
        int[] argTypes = {Types.INTEGER};
        return jdbcTemplate.queryForObject(sql, args, argTypes,  (rs, rowNum) -> {
            Publisher publisher = new Publisher();
            publisher.setId(rs.getLong("id"));
            publisher.setName(rs.getString("name"));
            return publisher;
        });
    }
}
