package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private  static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //null일때 null반환
        return Optional.ofNullable(store.get(id));

    }

    @Override
    public Optional<Member> findByName(String name) {

        //java8 람다 적용
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {

        //map으로 되어있는 store의 value값들을 list에 넣음
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
