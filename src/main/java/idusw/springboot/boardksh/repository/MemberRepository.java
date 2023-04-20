package idusw.springboot.boardksh.repository;

import idusw.springboot.boardksh.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // JpaRepository : 영속성 데이터를 처리하기 위해 ORM(Object Relation Mapping)을 정의한 JPA 사양서를 구현한 구현체에 대한 인터페이스
    // 'org.springFramework.boot:spring-boot-starter-data-jpa' : Spring-data-jpa 라이브러리에 포함됨

}
