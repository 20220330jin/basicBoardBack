package com.example.baseboard.repository;

import com.example.baseboard.domain.Board;
import com.example.baseboard.model.BoardDto;

import java.util.List;

public interface BoardRepositorySupport {

    List<BoardDto.boardList> boardList(BoardDto.boardListParam params);

    BoardDto.boardInfo boardInfo(Long boardId);

    Board findBoardByBoardId(Long boardId);
}
