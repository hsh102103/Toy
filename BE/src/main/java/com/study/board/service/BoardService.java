package com.study.board.service;

import com.study.board.dto.BoardCreateRequestDTO;
import com.study.board.dto.BoardSelectResponseDTO;
import com.study.board.dto.BoardUpdateRequestDTO;

import java.util.List;

public interface BoardService {
    // 게시글 생성
    void insertBoard(BoardCreateRequestDTO dto);

    // 게시글 조회
    BoardSelectResponseDTO getBoardById(Long id);

    // 게시글 전체 조회
    List<BoardSelectResponseDTO> getBoardList();

    // 게시글 수정
    void updateBoard(BoardUpdateRequestDTO dto);

    // 게시글 삭제
    void deleteBoard(Long id);

    void updateViewCnt(BoardSelectResponseDTO dto);
}
