package com.example.baseboard.repository;

import com.example.baseboard.domain.Board;
import com.example.baseboard.model.BoardDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class BoardRepositoryManagerImpl extends QuerydslRepositorySupport implements BoardRepositoryManager {

    final JPAQueryFactory jpaQueryFactory;

    public BoardRepositoryManagerImpl(EntityManager entityManager) {
        super(Board.class);
        super.setEntityManager(entityManager);
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public BoardDto.boardWrite boardWrite(BoardDto.boardWriteParam param) {
        final EntityManager entityManager = super.getEntityManager();
        final Board board = Board.create(param).get();
        entityManager.persist(board);
        return new BoardDto.boardWrite(board);
    }

    @Override
    public BoardDto.boardUpdate boardUpdate(Board board, BoardDto.boardUpdateParam param) {
        Board updatedBoard = board.update(board, param).get();
        return new BoardDto.boardUpdate(updatedBoard);
    }

    @Override
    public BoardDto.boardDelete boardDelete(Board board) {
        Board deleteBoard = board.delete(board).get();
        return new BoardDto.boardDelete(deleteBoard);
    }
}
