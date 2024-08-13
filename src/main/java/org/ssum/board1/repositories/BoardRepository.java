package org.ssum.board1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.ssum.board1.entities.Board;

public interface BoardRepository extends JpaRepository<Board,String>, QuerydslPredicateExecutor<Board> {
}
