package com20.database2023.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private int publicationYear;
    @ManyToOne
    private Author author;
    @ManyToMany
    private List<Genre> genres;
    @ManyToMany
    private List<Publisher> publishers;
}