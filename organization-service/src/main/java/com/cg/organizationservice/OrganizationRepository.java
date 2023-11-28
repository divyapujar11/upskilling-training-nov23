package com.cg.organizationservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.organizationservice.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByOrganizationCode(String organizationCode);
}
