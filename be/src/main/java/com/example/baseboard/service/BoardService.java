package com.example.baseboard.service;

import com.example.baseboard.model.BoardDto;

import java.util.List;

public interface BoardService {

    List<BoardDto.boardList> boardList(BoardDto.boardListParam params);

    BoardDto.boardInfo boardInfo(BoardDto.boardInfoParam param);

    BoardDto.boardWrite boardWrite(BoardDto.boardWriteParam param);
}
