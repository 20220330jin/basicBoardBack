package com.example.baseboard.domain;

import com.example.baseboard.model.BoardDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.function.Supplier;

@Entity
@Getter
public class Board extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "boardId")
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    public Board(){};

    public Board(Long createUserId
                 , LocalDateTime createDateTime
                 , LocalDateTime updateDateTime
                 , char useYn
                 , char delYn
                 , Long id
                 , String title
                 , String content
    ){
        super(createUserId, createDateTime, updateDateTime, useYn, delYn);
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Board(BoardDto.boardWriteParam param){
        this.title = param.getTitle();
        this.content = param.getContent();
    }

    public Board(Board board, BoardDto.boardUpdateParam param){
        board.title = param.getTitle();
        board.content = param.getContent();
        board.updateDateTime = LocalDateTime.now();
    }

    public Board(Board board){
        board.delYn = 'Y';
        board.useYn = 'N';
        board.updateDateTime = LocalDateTime.now();
    }


    public static Supplier<Board> create(BoardDto.boardWriteParam param){
        return () -> new Board(param);
    }

    public static Supplier<Board> update(Board board, BoardDto.boardUpdateParam param){
        return () -> new Board(board, param);
    }

    public static Supplier<Board> delete(Board board){
        return () -> new Board(board);
     }

}
