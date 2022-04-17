package com.example.baseboard.repository;

import com.example.baseboard.domain.Board;
import com.example.baseboard.model.BoardDto;

public interface BoardRepositoryManager {
    BoardDto.boardWrite boardWrite(BoardDto.boardWriteParam param);

    BoardDto.boardUpdate boardUpdate(Board board, BoardDto.boardUpdateParam param);

    BoardDto.boardDelete boardDelete(Board board);
}
