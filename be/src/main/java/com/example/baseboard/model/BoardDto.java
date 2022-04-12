package com.example.baseboard.model;

import com.example.baseboard.domain.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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

        private LocalDateTime createDateTime;

        public boardList(Long boardId
                        , String title
                        , String content
                        , LocalDateTime createDateTime
        ){
            this.boardId = boardId;
            this.title = title;
            this.content = content;
            this.createDateTime = createDateTime;
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
        private LocalDateTime createDateTime;

        public boardInfo(String title
                         , String content
                         , LocalDateTime createDateTime
        ){
            this.title = title;
            this.content = content;
            this.createDateTime = createDateTime;
        }
    }

    @Getter
    public static class boardWriteParam{
        private String title;
        private String content;
    }

    @Setter
    @Getter
    public static class boardWrite{
        private Long id;
        public boardWrite(Board board){
            this.id = board.getId();
        }
    }

    @Getter
    public static class boardUpdateParam{
        private Long boardId;
        private String title;
        private String content;
    }

    @Setter
    @Getter
    public static class boardUpdate{
        private Long boardId;

        public boardUpdate(Board board){
            this.boardId = board.getId();
        }
    }
}
