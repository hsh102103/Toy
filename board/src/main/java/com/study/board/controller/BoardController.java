package com.study.board.controller;

import com.study.board.dto.BoardCreateRequestDTO;
import com.study.board.dto.BoardSelectResponseDTO;
import com.study.board.service.BoardService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<BoardSelectResponseDTO> readBoard(@PathVariable Long id) {
        BoardSelectResponseDTO boardById = boardService.getBoardById(id);
        return ResponseEntity.status(HttpStatus.OK).body(boardById);
    }
//
//    public ResponseEntity updateBoard() {
//
//    }
//
//    public ResponseEntity deleteBoard() {
//
//    }

}
