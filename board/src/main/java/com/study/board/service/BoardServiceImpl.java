package com.study.board.service;


import com.study.board.dto.BoardCreateRequestDTO;
import com.study.board.dto.BoardSelectResponseDTO;
import com.study.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public void insertBoard(BoardRequestDTO dto) {
        boardMapper.insertBoard(dto);
    }

    @Override
    public BoardSelectResponseDTO getBoardById(Long id) {
        return boardMapper.getBoardById(id);
    }
//
//    @Override
//    public List<BoardDTO> getBoardList() {
//        return boardMapper.getBoardList();
//    }
//
//    @Override
//    public void updateBoard(BoardDTO boardDTO) {
//        boardMapper.updateBoard(boardDTO);
//    }
//
//    @Override
//    public void deleteBoard(Long id) {
//        boardMapper.deleteBoard(id);
//    }
}
