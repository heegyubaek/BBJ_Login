package com.bbj.bbj_login.repository;

import com.bbj.bbj_login.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sqeuence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sqeuence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findbyId(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> finaAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}