package com.smriti.configtest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query(value = "SELECT * FROM admin WHERE id = :id", nativeQuery=true)
    Admin getAdminById(@Param("id") Long id);
}
