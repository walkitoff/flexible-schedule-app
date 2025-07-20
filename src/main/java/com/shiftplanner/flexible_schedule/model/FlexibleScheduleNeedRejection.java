package com.shiftplanner.flexible_schedule.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "flexible_schedule_need_rejection")
public class FlexibleScheduleNeedRejection {
    @Id
    @Column(name = "rejection_id", nullable = false)
    private Long id;

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "rejected_at", nullable = false)
    private OffsetDateTime rejectedAt;

    @Size(max = 255)
    @Column(name = "rejection_note")
    private String rejectionNote;

}