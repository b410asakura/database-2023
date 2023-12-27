package com20.database2023.dao.impl;

import com20.database2023.dao.BookDao;
import com20.database2023.dto.response.BookResponse;
import com20.database2023.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {
    private final JdbcTemplate jdbcTemplate;


    @Override
    public void insert(Book book) {
        String sql = """
                INSERT INTO books (title, publication_year, author_id) VALUES ( ?, ?, ?)
                """;
        jdbcTemplate.update(sql, book.getTitle(), book.getPublicationYear(), book.getAuthor().getId());
        System.out.println("book was saved");
    }

    @Override
    public List<BookResponse> getAll() {
        String sql = """
                SELECT * FROM books
                """;
        return jdbcTemplate.query(sql, ((rs, rowNum) -> {
            BookResponse bookResponse = new BookResponse();
            bookResponse.setId(rs.getLong("id"));
            bookResponse.setTitle(rs.getString("title"));
            bookResponse.setPublicationYear(rs.getInt("publication_year"));
            return bookResponse;
        }));
    }

    @Override
    public void update(Long id, Book book) {
        String sql = "UPDATE books SET title = ?, publication_year = ? WHERE id = ?";
        jdbcTemplate.update(sql, book.getTitle(), book.getPublicationYear(), id);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM books WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void addRelationBookPublisher(Long bookId, Long publisherId) {
        String sql = """
                INSERT  INTO books_publishers (books_id, publishers_id)  VALUES (?, ?)
                """;
        jdbcTemplate.update(sql, bookId, publisherId);
        System.out.println("relation between book id " + bookId + " and" + "publisher id" + publisherId);
    }

    @Override
    public void addRelationBookGenre(Long bookId, Long genreId) {
        String sql = """
                INSERT INTO books_genres(books_id, genres_id)  VALUES (?, ?)
                """;
        jdbcTemplate.update(sql, bookId, genreId);
        System.out.println("relation between book id " + bookId + " and" + "publisher id" + genreId);
    }

    @Override
    public List<BookResponse> getAllByGenre(Long genreId) {
        String sql = """
                                select b.id, b.title from books b
                                join books_genres bg on b.id = bg.books_id
                                join genres g on bg.genres_id = g.id
                                where g.id = ?
                """;
        Object[] args = {genreId};
        int[] argTypes = {Types.INTEGER};
        return jdbcTemplate.query(sql, args, argTypes, (rs, rowNum) -> {
            BookResponse bookResponse = new BookResponse();
            bookResponse.setId(rs.getLong("id"));
            bookResponse.setTitle(rs.getString("title"));
            return bookResponse;
        });
    }

    @Override
    public List<BookResponse> getAllByAuthor(Long authorId) {
        String sql = """
                                select b.id, b.title from books b
                                                   join books_publishers bp on b.id = bp.books_id
                                                   join publishers p on bp.publishers_id = p.id
                                 where p.id = ?
                """;
        Object[] args = {authorId};
        int[] argTypes = {Types.INTEGER};
        return jdbcTemplate.query(sql, args, argTypes, (rs, rowNum) -> {
            BookResponse bookResponse = new BookResponse();
            bookResponse.setId(rs.getLong("id"));
            bookResponse.setTitle(rs.getString("title"));
            return bookResponse;
        });
    }
}
