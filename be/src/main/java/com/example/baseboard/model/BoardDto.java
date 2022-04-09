package com.example.baseboard.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
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

    @Getter
    @Setter
    public static class boardInfoParam{
        private Long boardId;
    }

    @Setter
    @Getter
    public static class boardInfo{
        private String title;
        private String content;

        public boardInfo(String title
                        , String content
        ){
            this.title = title;
            this.content = content;
        }
    }
}
