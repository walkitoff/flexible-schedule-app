package com.shiftplanner.flexible_schedule.repository;

import com.shiftplanner.flexible_schedule.model.FlexibleScheduleNeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlexibleScheduleNeedRepository extends JpaRepository<FlexibleScheduleNeed, Long> {

}
