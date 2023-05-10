package com.study.board.service;


import com.study.board.dto.BoardRequestDTO;
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
}
