package com.example.baseboard.service;

import com.example.baseboard.domain.Board;
import com.example.baseboard.model.BoardDto;
import com.example.baseboard.repository.BoardRepositoryManager;
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

    final BoardRepositoryManager boardRepositoryManager;

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

    @Override
    public BoardDto.boardWrite boardWrite(BoardDto.boardWriteParam param) {
        return boardRepositoryManager.boardWrite(param);
    }

    @Override
    public BoardDto.boardUpdate boardUpdate(BoardDto.boardUpdateParam param) {
        Optional<Long> checkId = Optional.ofNullable(param.getBoardId());
        if(!checkId.isPresent()){

        }
        Long boardId = param.getBoardId();
        String title = param.getTitle();
        String content = param.getContent();
        Board board = boardRepositorySupport.findBoardByBoardId(boardId);
        return boardRepositoryManager.boardUpdate(board, param);
    }

    @Override
    public BoardDto.boardDelete boardDelete(BoardDto.boardDeleteParam param) {
        Optional<Long> checkId = Optional.ofNullable(param.getBoardId());
        if(!checkId.isPresent()){

        }
        Long boardId = param.getBoardId();
        Board board = boardRepositorySupport.findBoardByBoardId(boardId);

        return boardRepositoryManager.boardDelete(board);
    }
}
