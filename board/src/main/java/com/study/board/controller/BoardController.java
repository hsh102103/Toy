package com.study.board.controller;

import com.study.board.dto.BoardRequestDTO;
import com.study.board.service.BoardService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    @Resource
    private BoardService boardService;

    @PostMapping
    public ResponseEntity createBoard(@RequestBody BoardRequestDTO dto) {
        boardService.insertBoard(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
