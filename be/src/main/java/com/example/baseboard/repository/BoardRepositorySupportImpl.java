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

        final BooleanExpression isUseYn = board.useYn.eq('Y');
        final BooleanExpression isDelYn = board.delYn.eq('N');

        return jpaQueryFactory.select(Projections.constructor(BoardDto.boardList.class
                                                            , board.id
                                                            , board.title
                                                            , board.content
                                                            , board.createDateTime
                ))
                .from(board)
                .where(isUseYn
                        .and(isDelYn)
                )
                .fetch();
    }

    @Override
    public BoardDto.boardInfo boardInfo(Long boardId) {
        QBoard board = QBoard.board;

        final BooleanExpression isBoardId = board.id.eq(boardId);

        final BooleanExpression isUseYn = board.useYn.eq('Y');
        final BooleanExpression isDelYn = board.delYn.eq('N');

        return jpaQueryFactory.select(Projections.constructor(BoardDto.boardInfo.class
                                        , board.title
                                        , board.content
                                        , board.createDateTime
                ))
                .from(board)
                .where(isBoardId
                        .and(isUseYn)
                        .and(isDelYn)
                )
                .fetchOne();
    }

    @Override
    public Board findBoardByBoardId(Long boardId) {
        QBoard board = QBoard.board;

        final BooleanExpression isBoardId = board.id.eq(boardId);

        final BooleanExpression isUseYn = board.useYn.eq('Y');
        final BooleanExpression isDelYn = board.delYn.eq('N');
        return jpaQueryFactory.select(board)
                .from(board)
                .where(isBoardId
                        .and(isUseYn)
                        .and(isDelYn)
                )
                .fetchOne();

    }
}
