package com20.database2023.dao.impl;

import com20.database2023.dao.AuthorDao;
import com20.database2023.dto.response.AuthorResponse;
import com20.database2023.entity.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthorDaoImpl implements AuthorDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Author author) {
        String sql = """
                INSERT INTO authors (name, email) VALUES ( ?, ?)
                """;
        jdbcTemplate.update(sql, author.getName(), author.getEmail());
        System.out.println("author was saved");
    }

    @Override
    public List<AuthorResponse> getAll() {
        String sql = """
                SELECT * FROM authors
                """;
        return jdbcTemplate.query(sql,((rs, rowNum) -> {
            AuthorResponse authorResponse = new AuthorResponse();
            authorResponse.setId(rs.getLong("id"));
            authorResponse.setName(rs.getString("name"));
            authorResponse.setEmail(rs.getString("email"));
            return authorResponse;
        }));
    }

    @Override
    public Author findById(Long id){
        String sql = """
                SELECT * FROM authors
                where authors.id = ?
                """;
        Object[] args = {id};
        int[] argTypes = {Types.INTEGER};
        return jdbcTemplate.queryForObject(sql, args, argTypes,  (rs, rowNum) -> {
            Author author = new Author();
            author.setId(rs.getLong("id"));
            author.setName(rs.getString("name"));
            author.setEmail(rs.getString("email"));
            return author;
        });
    }

    @Override
    public void update(Long id, Author author) {
        String sql = "UPDATE authors SET  name = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(sql,author.getName(), author.getEmail(), id);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM authors WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
