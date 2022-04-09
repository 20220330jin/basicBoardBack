package com.example.baseboard.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

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
                 , Character useYn
                 , Character delYn
                 , Long id
                 , String title
                 , String content
    ){
        super(createUserId, createDateTime, updateDateTime, useYn, delYn);
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
