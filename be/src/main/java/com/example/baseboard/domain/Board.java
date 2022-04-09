package com.example.baseboard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Board {

    @Id
    @GeneratedValue
    @Column(name = "boardId")
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    public Board(Long id
                 , String title
                 , String content
    ){
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
