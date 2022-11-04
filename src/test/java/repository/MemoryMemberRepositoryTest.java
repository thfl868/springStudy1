package repository;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository() ;

    //하나 테스트 할때 마다 저장한걸 지워주는 것
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void  save(){
        Member member = new Member();
        member.setName("string");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
        //Assertions.assertEquals( member, result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("string1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("string2");
        repository.save(member2);

        Member result = repository.findByName("string1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("string1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("string2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
