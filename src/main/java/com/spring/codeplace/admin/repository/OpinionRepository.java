package com.spring.codeplace.admin.repository;

import com.spring.codeplace.admin.entity.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepository extends JpaRepository <Opinion, Long> {
    Opinion findByOid(Long oid);
}
