package com20.database2023.dao.impl;

import com20.database2023.dao.GenreDao;
import com20.database2023.dto.response.GenreResponse;
import com20.database2023.entity.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GenreDaoImpl implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Genre genre) {
        String sql = """
                INSERT INTO genres (name) VALUES (?)
                """;
        jdbcTemplate.update(sql, genre.getName());
    }

    @Override
    public List<GenreResponse> getAll() {
        String sql = """
                SELECT * FROM genres
                """;
        return jdbcTemplate.query(sql,((rs, rowNum) -> {
            GenreResponse genreResponse = new GenreResponse();
            genreResponse.setId(rs.getLong("id"));
            genreResponse.setName(rs.getString("name"));
            return genreResponse;
        }));
    }

    @Override
    public void update(Long id, Genre genre) {
        String sql = """
                UPDATE genres SET name = ? WHERE id = ?
                """;
        jdbcTemplate.update(sql, genre.getName(), id);
    }

    @Override
    public void delete(Long id) {
        String sql = """
                DELETE FROM genres WHERE id = ?
                """;
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Genre findById(Long id) {
        String sql = """
                SELECT * FROM genres
                where genres.id = ?
                """;
        Object[] args = {id};
        int[] argTypes = {Types.INTEGER};
        return jdbcTemplate.queryForObject(sql, args, argTypes,  (rs, rowNum) -> {
            Genre genre = new Genre();
            genre.setId(rs.getLong("id"));
            genre.setName(rs.getString("name"));
            return genre;
        });
    }
}