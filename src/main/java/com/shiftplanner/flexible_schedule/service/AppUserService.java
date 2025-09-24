package com.shiftplanner.flexible_schedule.service;

import com.shiftplanner.flexible_schedule.model.AppUser;
import com.shiftplanner.flexible_schedule.model.Department;
import com.shiftplanner.flexible_schedule.model.Role;
import com.shiftplanner.flexible_schedule.repository.AppUserRepository;
import com.shiftplanner.flexible_schedule.repository.DepartmentRepository;
import com.shiftplanner.flexible_schedule.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    private final AppUserRepository users;
    private final DepartmentRepository departments;
    private final RoleRepository roles;
    private final PasswordEncoder passwordEncoder;


    public AppUserService(
            AppUserRepository users,
            DepartmentRepository departments,
            RoleRepository roles,
            PasswordEncoder passwordEncoder
    ){

        this.users = users;
        this.departments = departments;
        this.roles = roles;
        this.passwordEncoder = passwordEncoder;
    }


    @Transactional
    public AppUser registerUser(
            String badgeId,
            String firstName,
            String lastName,
            String email,          // optional
            String phoneNumber,    // optional
            Integer departmentId,
            Integer roleId,
            String rawPassword,
            String preferredLanguage // optional
    ) {
        // Normalize/trim (avoid persisting accidental spaces)
        badgeId = safeTrim(badgeId);
        firstName = safeTrim(firstName);
        lastName = safeTrim(lastName);
        email = safeTrim(email);
        phoneNumber = safeTrim(phoneNumber);
        preferredLanguage = safeTrim(preferredLanguage);

        // Guard rails
        if (badgeId == null || badgeId.isBlank()) {
            throw new IllegalArgumentException("badgeId is required.");
        }
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("firstName is required.");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("lastName is required.");
        }
        if (rawPassword == null || rawPassword.isBlank()) {
            throw new IllegalArgumentException("password is required.");
        }
        if (users.existsById(badgeId)) {
            throw new IllegalArgumentException("Badge ID already exists.");
        }

        //  email uniqueness check (add existsByEmail to your repo if you want single-email policy)
        // if (email != null && !email.isBlank() && users.existsByEmail(email)) {
        //     throw new IllegalArgumentException("Email already in use.");
        // }

        // A Basic password policy
        validatePasswordStrength(rawPassword);

        Department dept = departments.findById(departmentId)
                .orElseThrow(() -> new IllegalArgumentException("Department not found."));
        Role role = roles.findById(roleId)
                .orElseThrow(() -> new IllegalArgumentException("Role not found."));

        // Build entity
        AppUser u = new AppUser();
        u.setBadgeId(badgeId);
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setEmail(email);
        u.setPhoneNumber(phoneNumber);
        u.setDepartment(dept);
        u.setRole(role);
        u.setPreferredLanguage(preferredLanguage);
        u.setPasswordHash(passwordEncoder.encode(rawPassword)); // never store raw

        // DB will set created_at/updated_at per your defaults;
        // consider @PrePersist/@PreUpdate in the entity for app-side timestamps too.

        return users.save(u);
    }

    public AppUser getByBadgeId(String badgeId) {
        return users.findById(badgeId)
                .orElseThrow(() -> new IllegalArgumentException("User not found."));
    }



    // ---------- helpers ----------

    private static String safeTrim(String s) {
        return s == null ? null : s.trim();
    }


    /** "Password must be >= 8 character & include upper, lower, digit, and symbol." */
    private static void validatePasswordStrength(String pwd) {

        if (pwd.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters.");
        }

        boolean hasUpper = false,
                hasLower = false,
                hasDigit = false,
                hasSymbol = false;

        for (char c : pwd.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSymbol = true;
        }

        if (!(hasUpper && hasLower && hasDigit && hasSymbol)) {
            throw new IllegalArgumentException(
                    "Password must include upper, lower, digit, and symbol."
            );
        }
    }


}
