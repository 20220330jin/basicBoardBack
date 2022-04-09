package com.example.baseboard.service;

import com.example.baseboard.model.BoardDto;
import com.example.baseboard.repository.BoardRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    final BoardRepositorySupport boardRepositorySupport;

    @Override
    public List<BoardDto.boardList> boardList(BoardDto.boardListParam params) {
        return boardRepositorySupport.boardList(params);
    }

    @Override
    public BoardDto.boardInfo boardInfo(BoardDto.boardInfoParam param) {
        Optional<Long> boardIdCheck = Optional.ofNullable(param.getBoardId());
        if(!boardIdCheck.isPresent()){

        }
        Long boardId = param.getBoardId();
        return boardRepositorySupport.boardInfo(boardId);
    }
}
