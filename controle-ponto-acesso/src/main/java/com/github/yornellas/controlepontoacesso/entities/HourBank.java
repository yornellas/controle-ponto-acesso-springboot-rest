package com.github.yornellas.controlepontoacesso.entities;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class HourBank {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class HourBankId implements Serializable {
        private Long hourBankId;
        private Long movementId;
        private Long userId;
    }

    @EmbeddedId
    private HourBankId id;

    private LocalDateTime workedDate;
    private BigDecimal workedHours;
    private BigDecimal workedHoursBalance;

    public HourBankId getId() {
        return id;
    }

    public void setId(HourBankId id) {
        this.id = id;
    }

    public LocalDateTime getWorkedDate() {
        return workedDate;
    }

    public void setWorkedDate(LocalDateTime workedDate) {
        this.workedDate = workedDate;
    }

    public BigDecimal getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(BigDecimal workedHours) {
        this.workedHours = workedHours;
    }

    public BigDecimal getWorkedHoursBalance() {
        return workedHoursBalance;
    }

    public void setWorkedHoursBalance(BigDecimal workedHoursBalance) {
        this.workedHoursBalance = workedHoursBalance;
    }
}
