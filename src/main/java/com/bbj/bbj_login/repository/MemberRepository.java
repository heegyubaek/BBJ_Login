package com.bbj.bbj_login.repository;

import com.bbj.bbj_login.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findbyId(Long id);
    Optional<Member> findByName(String name);
    List<Member> finaAll();
}
