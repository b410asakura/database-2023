package com20.database2023.dao.impl;

import com20.database2023.dao.AuthorDao;
import com20.database2023.dto.response.AuthorBookResponse;
import com20.database2023.dto.response.AuthorResponse;
import com20.database2023.entity.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
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
    public void update(Long id, Author author) {
        String sql = "UPDATE authors SET email = ? WHERE id = ?";
        jdbcTemplate.update(sql, author.getEmail(), id);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM authors WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public AuthorBookResponse getAuthorBooks(Long id) {
        String sql = """
                select
                    a.id,
                    a.name,
                    a.email,
                    (select array_agg(b.title) as book_title)
                    from authors a
                join books b on a.id = b.author_id where a.id = ?
                """;
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->{
            AuthorBookResponse authorResponse = new AuthorBookResponse();
            authorResponse.setId(rs.getLong("id"));
            authorResponse.setName(rs.getString("name"));
            authorResponse.setEmail(rs.getString("email"));
            List<String> bookTitle = Arrays.asList((String[]) rs.getArray("book_title").getArray());
            authorResponse.setBooksTitles(bookTitle);
            return authorResponse;
        },id);
    }
}
