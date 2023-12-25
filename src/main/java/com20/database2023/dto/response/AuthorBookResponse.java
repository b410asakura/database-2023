package com20.database2023.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorBookResponse {
    private Long id;
    private String name;
    private String email;
    private List<String>booksTitles;
}