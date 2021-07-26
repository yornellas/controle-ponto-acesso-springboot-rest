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
public class Movement {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class MovementId implements Serializable {
        private Long movementId;
        private Long userId;
    }

    @EmbeddedId
    private MovementId id;

    private LocalDateTime startDate;
    private LocalDateTime exitDate;
    private BigDecimal permanencePeriod;

    @ManyToOne
    private Occurrence occurrence;

    @ManyToOne
    private Calendar calendar;

    public MovementId getId() {
        return id;
    }

    public void setId(MovementId id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDateTime exitDate) {
        this.exitDate = exitDate;
    }

    public BigDecimal getPermanencePeriod() {
        return permanencePeriod;
    }

    public void setPermanencePeriod(BigDecimal permanencePeriod) {
        this.permanencePeriod = permanencePeriod;
    }

    public Occurrence getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(Occurrence occurrence) {
        this.occurrence = occurrence;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
