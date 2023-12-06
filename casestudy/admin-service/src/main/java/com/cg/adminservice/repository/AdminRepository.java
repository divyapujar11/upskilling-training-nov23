package com.cg.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.adminservice.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
