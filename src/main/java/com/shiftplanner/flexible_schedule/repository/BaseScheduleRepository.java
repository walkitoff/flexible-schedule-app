package com.shiftplanner.flexible_schedule.repository;


import com.shiftplanner.flexible_schedule.model.BaseSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseScheduleRepository extends JpaRepository<BaseSchedule, String> {
}
