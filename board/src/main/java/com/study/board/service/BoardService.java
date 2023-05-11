package com.study.board.service;

import com.study.board.dto.BoardCreateRequestDTO;
import com.study.board.dto.BoardSelectResponseDTO;

public interface BoardService {
    // 게시글 생성
    void insertBoard(BoardCreateRequestDTO dto);
    // 게시글 조회
    BoardSelectResponseDTO getBoardById(Long id);
//    // 게시글 전체 조회
//    List<BoardDTO> getBoardList();
//    // 게시글 수정
//    void updateBoard(BoardDTO boardDTO);
//    // 게시글 삭제
//    void deleteBoard(Long id);
}
