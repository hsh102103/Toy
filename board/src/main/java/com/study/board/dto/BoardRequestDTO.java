package com.study.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequestDTO {
    private Long id;
    private String title;
    private String content;
    private String writer;
}
