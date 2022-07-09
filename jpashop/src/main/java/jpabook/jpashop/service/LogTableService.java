package jpabook.jpashop.service;

import jpabook.jpashop.domain.LogTable;
import jpabook.jpashop.repository.LogTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@Transactional
@RequiredArgsConstructor
public class LogTableService {

    private final LogTableRepository logTableRepository;

    @Transactional
    public void logInsert() {
        logTableRepository.save(new LogTable(LocalDate.now(), LocalTime.now()));
    }
}
