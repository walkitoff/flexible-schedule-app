package com.shiftplanner.flexible_schedule.repository;


import com.shiftplanner.flexible_schedule.model.FlexibleScheduleNeedRejection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlexibleScheduleNeedRejectionRepository
        extends JpaRepository<FlexibleScheduleNeedRejection, Long> {

}
