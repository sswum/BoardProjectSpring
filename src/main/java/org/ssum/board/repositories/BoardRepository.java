package org.ssum.board.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.ssum.board.entities.Board;

public interface BoardRepository extends JpaRepository<Board ,String>, QuerydslPredicateExecutor<Board> {
}
