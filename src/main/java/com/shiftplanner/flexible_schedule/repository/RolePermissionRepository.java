package com.shiftplanner.flexible_schedule.repository;

import com.shiftplanner.flexible_schedule.model.RolePermission;
import com.shiftplanner.flexible_schedule.model.RolePermissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//RolePermission uses a composite ID called RolePermissionId  (role_id, Permission_id)
@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, RolePermissionId> {

}
