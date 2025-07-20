package com.shiftplanner.flexible_schedule.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "base_schedule")
public class BaseSchedule {
    @Id
    @Size(max = 100)
    @Column(name = "badge_id", nullable = false, length = 100)
    private String badgeId;

    @Column(name = "mon")
    private LocalTime mon;

    @Column(name = "tue")
    private LocalTime tue;

    @Column(name = "wed")
    private LocalTime wed;

    @Column(name = "thu")
    private LocalTime thu;

    @Column(name = "fri")
    private LocalTime fri;

    @Column(name = "sat")
    private LocalTime sat;

    @Column(name = "sun")
    private LocalTime sun;

}