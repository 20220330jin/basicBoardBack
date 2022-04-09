package com.example.baseboard.repository;

import com.example.baseboard.domain.Board;
import com.example.baseboard.domain.QBoard;
import com.example.baseboard.model.BoardDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BoardRepositorySupportImpl extends QuerydslRepositorySupport implements BoardRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public BoardRepositorySupportImpl(EntityManager entityManager) {
        super(Board.class);
        super.setEntityManager(entityManager);
        jpaQueryFactory = new JPAQueryFactory(entityManager);

    }

    @Override
    public List<BoardDto.boardList> boardList(BoardDto.boardListParam params) {
        QBoard board = QBoard.board;
        return jpaQueryFactory.select(Projections.constructor(BoardDto.boardList.class
                                                            , board.id
                                                            , board.title
                                                            , board.content
                ))
                .from(board)
                .fetch();
    }

    @Override
    public BoardDto.boardInfo boardInfo(Long boardId) {
        QBoard board = QBoard.board;

        final BooleanExpression isBoardId = board.id.eq(boardId);
//        final BooleanExpression isUseYn = board
        return jpaQueryFactory.select(Projections.constructor(BoardDto.boardInfo.class
                                        , board.title
                                        , board.content
                ))
                .from(board)
                .where(isBoardId)
                .fetchOne();
    }
}
