package com.study.board.controller;

import com.study.board.dto.BoardCreateRequestDTO;
import com.study.board.dto.BoardSelectResponseDTO;
import com.study.board.dto.BoardUpdateRequestDTO;
import com.study.board.service.BoardService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    @Resource
    private BoardService boardService;

    @PostMapping
    public ResponseEntity createBoard(@RequestBody BoardCreateRequestDTO dto) {
        boardService.insertBoard(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardSelectResponseDTO> readOneById(@PathVariable Long id) {
        BoardSelectResponseDTO boardById = boardService.getBoardById(id);
        boardService.updateViewCnt(boardById);
        return ResponseEntity.status(HttpStatus.OK).body(boardById);
    }

    @GetMapping
    public ResponseEntity<List<BoardSelectResponseDTO>> readAll() {
        List<BoardSelectResponseDTO> boardList = boardService.getBoardList();
        return ResponseEntity.status(HttpStatus.OK).body(boardList);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBoard(@PathVariable Long id, @RequestBody BoardUpdateRequestDTO dto) {
        dto.setId(id);
        boardService.updateBoard(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
