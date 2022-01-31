package com.bbj.bbj_login.service;

import com.bbj.bbj_login.domain.Member;
import com.bbj.bbj_login.repository.MemberRepository;
import com.bbj.bbj_login.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {

    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    //회원가입
    public Long join(Member member){
        // 같은 이름을 가진 중복회원 X
        validateDuplicateMember(member); // 중복회원 검증
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.finaAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findbyId(memberId);
    }

}
