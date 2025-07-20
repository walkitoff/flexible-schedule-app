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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "flexible_schedule_need")
public class FlexibleScheduleNeed {
    @Id
    @Column(name = "sched_need_id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "date_of_need", nullable = false)
    private LocalDate dateOfNeed;

    @NotNull
    @Column(name = "time_of_need", nullable = false)
    private LocalTime timeOfNeed;

    @Size(max = 20)
    @NotNull
    @Column(name = "position_need", nullable = false, length = 20)
    private String positionNeed;

    @Size(max = 20)
    @NotNull
    @Column(name = "type_of_need", nullable = false, length = 20)
    private String typeOfNeed;

    @Size(max = 255)
    @Column(name = "manager_notes")
    private String managerNotes;

    @Size(max = 20)
    @NotNull
    @ColumnDefault("'OPEN'")
    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "accepted_at")
    private OffsetDateTime acceptedAt;

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

}