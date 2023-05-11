package com.study.board.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerTest {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("게시글 생성 성공 - web layer")
    void createBoard() throws Exception {
        // given
        Map<String, String> info = new HashMap<>();
        info.put("content", "content");
        info.put("title", "title");
        info.put("writer", "kwan");

        mvc.perform(post("/api/board")
                        .contentType(MediaType.APPLICATION_JSON) // 요청에 담긴 데이터의 미디어타입
                        .accept(MediaType.APPLICATION_JSON) // 클라이언트가 처리 가능한 미디어타입
                        .content(objectMapper.writeValueAsString(info))
                ).andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    @DisplayName("게시글 조회 성공 - web layer")
    void getBoardById() throws Exception {
        // 반환하는 객체의 일부만 확인할 수는 없나..

        Long id = 6L;
        mvc.perform(get("/api/board/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andDo(print());
    }
}