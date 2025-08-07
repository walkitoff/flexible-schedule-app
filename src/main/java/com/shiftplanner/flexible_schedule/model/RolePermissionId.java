package com.shiftplanner.flexible_schedule.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class represents the composite primary key for RolePermission.
 * The key is made up of two columns: role_id and permission_id.
 */
@Getter
@Setter
@Embeddable
public class RolePermissionId implements Serializable {

    // The role ID part of the composite key
    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    // The permission ID part of the composite key
    @Column(name = "permission_id", nullable = false)
    private Integer permissionId;

    // Default constructor (required by JPA)
    public RolePermissionId() {}

    // Constructor with both fields
    public RolePermissionId(Integer roleId, Integer permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }


    // equals() compares two IDs by checking both fields
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolePermissionId)) return false;
        RolePermissionId that = (RolePermissionId) o;
        return Objects.equals(roleId, that.roleId) &&
                Objects.equals(permissionId, that.permissionId);
    }

    // hashCode() generates a unique hash based on both fields
    @Override
    public int hashCode() {
        return Objects.hash(roleId, permissionId);
    }
}
