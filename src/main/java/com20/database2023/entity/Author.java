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
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "author")
    private List<Book> books;
}