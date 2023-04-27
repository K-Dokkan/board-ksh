package idusw.springboot.boardksh.service;

import idusw.springboot.boardksh.domain.Member;
import idusw.springboot.boardksh.domain.Memo;
import idusw.springboot.boardksh.entity.MemberEntity;
import idusw.springboot.boardksh.entity.MemoEntity;
import idusw.springboot.boardksh.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 생성자 주입
@Service
public class MemberServiceImpl implements MemberService{

    MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public int create(Member m) {
        MemberEntity entity = MemberEntity.builder()
                .seq(m.getSeq())
                .email(m.getEmail())
                .name(m.getName())
                .pw(m.getPw())
                .build();
        if(memberRepository.save(entity) != null)
            return 1;
        else
            return 0;
    }

    @Override
    public Member read(Member m) {
        MemberEntity e = memberRepository.getById(m.getSeq());
        Member member = Member.builder()
                .seq(e.getSeq())
                .email(e.getEmail())
                .name(e.getName())
                .pw(e.getPw())
                .build();
        return member;
    }

    @Override
    public List<Member> readList() {
        // 1. 매개변수를 처리하고(처리를 위한 객체 선언 및 초기화), repository 객체에게 전달
        // 2. repository 객체의 해당 메소드가 처리한 후 결과를 반환 유형으로 변환
        // repository : entity 객체를 대상으로 함, service : dto or domain 객체를 대상으로 함
        List<Member> result = new ArrayList<>(); // Memo 객체를 원소로 갖는 리스트형 객체를 생성, 배정
        List<MemberEntity> entities = memberRepository.findAll(); // select * from a_memo;
        for(MemberEntity e : entities) {
            // function language 특징을 활용한 처리 1.8 lambda 식, lombok library
            Member m = Member.builder()
                    .seq(e.getSeq())
                    .email(e.getEmail())
                    .name(e.getName())
                    .build();// DTO (Data Transfer Object) : Controller - Service or Controller - View
            result.add(m);
        }
        return result;
    }

    @Override
    public int update(Member m) {
        return 0;
    }

    @Override
    public int delete(Member m) {
        return 0;
    }

    @Override
    public Member login(Member m) { // 인터페이스에 선언된 메소드 중 구현하지 않은 메소드를 구현해야함
        Member result = null;
        MemberEntity entity = memberRepository.getByEmailPw(m.getEmail(),m.getPw());
        if(entity != null){
            result = new Member();
            result.setSeq(entity.getSeq());
            result.setEmail(entity.getEmail());
            result.setName(entity.getName());
            result.setPw(entity.getPw());
        }

        return result;
    }
}
