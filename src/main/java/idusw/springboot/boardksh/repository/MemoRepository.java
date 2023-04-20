package idusw.springboot.boardksh.repository;

import idusw.springboot.boardksh.entity.MemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<MemoEntity, Long> {

}
