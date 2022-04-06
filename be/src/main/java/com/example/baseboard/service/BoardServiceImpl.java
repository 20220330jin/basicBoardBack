package com.example.baseboard.service;

import com.example.baseboard.model.BoardDto;
import com.example.baseboard.repository.BoardRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    final BoardRepositorySupport boardRepositorySupport;

    @Override
    public List<BoardDto.boardList> boardList(BoardDto.boardListParam params) {
        return boardRepositorySupport.boardList(params);
    }
}
