package com.shiftplanner.flexible_schedule.repository;

import com.shiftplanner.flexible_schedule.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
