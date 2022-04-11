package com.example.baseboard.repository;

import com.example.baseboard.model.BoardDto;

public interface BoardRepositoryManager {
    BoardDto.boardWrite boardWrite(BoardDto.boardWriteParam param);
}
