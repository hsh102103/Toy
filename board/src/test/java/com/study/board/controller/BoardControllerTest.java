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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerTest {
    static final String url = "/api/board";

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

        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON) // 요청에 담긴 데이터의 미디어타입
                        .accept(MediaType.APPLICATION_JSON) // 클라이언트가 처리 가능한 미디어타입
                        .content(objectMapper.writeValueAsString(info))
                ).andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    @DisplayName("게시글 단일 조회 성공 - web layer")
    void readOneById() throws Exception {
        // 반환하는 객체의 일부만 확인할 수는 없나..

        Long id = 4L;
        mvc.perform(get(url + "/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("게시글 전체 조회 성공 - web layer")
    void readAll() throws Exception {
        mvc.perform(get(url)
                ).andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("게시글 수정 성공 - web layer")
    void updateBoard() throws Exception {
        Map<String, String> info = new HashMap<>();
        info.put("content", "update Content");
        info.put("title", "update Title");

        Long id = 1L;
        mvc.perform(put(url + "/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(info))
                ).andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    @DisplayName("게시글 삭제 성공 - web layer")
    void deleteBoard() throws Exception {
        Long id = 6L;
        mvc.perform(delete(url + "/" + id)
                ).andExpect(status().isNoContent())
                .andDo(print());
    }
}