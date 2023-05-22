package com.study.board.service;


import com.study.board.dto.BoardCreateRequestDTO;
import com.study.board.dto.BoardSelectResponseDTO;
import com.study.board.dto.BoardUpdateRequestDTO;
import com.study.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public void insertBoard(BoardCreateRequestDTO dto) {
        boardMapper.insertBoard(dto);
    }

    @Override
    public BoardSelectResponseDTO getBoardById(Long id) {
        return boardMapper.getBoardById(id);
    }

    @Override
    public List<BoardSelectResponseDTO> getBoardList() {
        return boardMapper.getBoardList();
    }

    @Override
    public void updateBoard(BoardUpdateRequestDTO dto) {
        boardMapper.updateBoard(dto);
    }

    public void updateViewCnt(BoardSelectResponseDTO dto) {
        Long viewCnt = dto.getViewCnt();
        if (viewCnt == null) {
            viewCnt = 1L;
        } else {
            viewCnt = viewCnt + 1;
        }
        dto.setViewCnt(viewCnt);
        boardMapper.increaseViewCnt(dto);
    }

    @Override
    public void deleteBoard(Long id) {
        boardMapper.deleteBoard(id);
    }
}
