package org.ssum.member.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.ssum.member.entities.Authorities;
import org.ssum.member.entities.AuthoritiesId;
import org.ssum.member.entities.Member;

import java.util.List;

public interface AuthoritiesRepository extends JpaRepository<Authorities, AuthoritiesId>, QuerydslPredicateExecutor<Authorities> {

    List<Authorities> findByMember(Member member);


}
