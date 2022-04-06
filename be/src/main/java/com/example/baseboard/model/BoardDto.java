package com.example.baseboard.model;

import lombok.Getter;

public class BoardDto {

    public static class boardListParam{
        // 검색조건: 제목
        private String title;
    }

    // Response
    @Getter
    public static class boardList{
        private Long boardId;

        private String title;

        private String content;

        public boardList(Long boardId
                       , String title
                       , String content
        ){
            this.boardId = boardId;
            this.title = title;
            this.content = content;
        }
    }
}
