package com.study.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardSelectResponseDTO {
    Long id;
    String title;
    String content;
    String writer;
    Long viewCnt;
    Boolean noticeYn;
    Boolean deleteYn;
    

}
