package com.shiftplanner.flexible_schedule.repository;

import com.shiftplanner.flexible_schedule.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
