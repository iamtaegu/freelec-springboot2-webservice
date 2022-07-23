package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor<Member> {

    //select m from Member m where m.name = ?
    List<Member> findByName(String name);

    // JPAL은 위치 기반 파라미터를 1부터 시작하지만
    // 네이티브는 0부터 시작함
    //@Query("select m from Member m where m.email = ?1 or m.name =?2")
    //@Query(value = "select m from Member m where m.name =?1", nativeQuery = true)
    @Query("select m from Member m where m.name =:inputEmail or m.email =:inputName")
    List<Member> findByEmailOrName(@Param("inputName") String name, @Param("inputEmail")String email);

    // 페이징과 정렬
    // List<Member> count 쿼리 미사용
    // count 쿼리 사용
    Page<Member> findByNameStartingWith(String name, Pageable pageable);
}
