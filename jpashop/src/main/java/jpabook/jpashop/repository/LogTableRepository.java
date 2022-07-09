package jpabook.jpashop.repository;

import jpabook.jpashop.domain.LogTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogTableRepository extends JpaRepository<LogTable, Long> {
}
