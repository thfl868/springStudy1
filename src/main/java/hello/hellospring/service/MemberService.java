package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    //command + shift+ t : test 생성

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //같은 db쓰기위해 memberRepository를 외부에서 생성해서 넣음
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    /**
    * 회원가입
    * */
    public Long join(Member member){
        //같은 이름이 있는 중복회원x
        validateDuplicateMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * id로 회원조회
     * */
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


}
