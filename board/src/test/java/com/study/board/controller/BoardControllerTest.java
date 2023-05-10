package com.study.board.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

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
    void createBoard() throws Exception {
        // given
        Map<String, String> info = new HashMap<>();
        info.put("content", "content");
        info.put("title", "title");
        info.put("writer", "kwan");

        mvc.perform(post("/api/board")
                        .contentType(MediaType.APPLICATION_JSON) // 요청에 담긴 데이터의 미디어타입
                        .accept(MediaType.APPLICATION_JSON) // 클라이언트가 처리 가능한 미디어타입
                        .content(objectMapper.writeValueAsString(info)))
                .andExpect(status().isCreated())
                .andDo(print());
    }
}