package org.ssum.sumstay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.ssum.sumstay.entities.Stay;

public interface SumStayRepositories extends JpaRepository<Stay, Long>, QuerydslPredicateExecutor<Stay> {

}
