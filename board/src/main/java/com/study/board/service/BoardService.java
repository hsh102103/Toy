package com.study.board.service;

import com.study.board.dto.BoardRequestDTO;

public interface BoardService {
    // 게시글 생성
    void insertBoard(BoardRequestDTO dto);
}
