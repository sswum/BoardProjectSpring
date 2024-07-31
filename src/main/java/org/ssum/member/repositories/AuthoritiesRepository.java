package org.ssum.member.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.ssum.global.entities.Member;
import org.ssum.member.entities.Authorities;
import org.ssum.member.entities.AuthoritiesId;

import java.util.List;

public interface AuthoritiesRepository extends JpaRepository<Authorities, AuthoritiesId>, QuerydslPredicateExecutor<Authorities> {

    List<Authorities> findByMember(Member member);


}
