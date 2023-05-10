package com.study.board.mapper;

import com.study.board.dto.BoardRequestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    // 게시글 생성
    void insertBoard(BoardRequestDTO dto);
}
