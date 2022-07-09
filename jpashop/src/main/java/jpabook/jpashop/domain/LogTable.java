package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class LogTable {

    @Id
    @GeneratedValue
    @Column(name = "seq_no")
    private Long seqNo;

    private LocalDate logDate;

    private LocalTime logTime;

    public LogTable(LocalDate logDate, LocalTime logTime) {
        this.logDate = logDate;
        this.logTime = logTime;
    }
}
