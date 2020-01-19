package com.spring.codeplace.user.repository;

import com.spring.codeplace.user.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByOid(Long oid);

    Page<User> findByAccountLike(Pageable pageable, String accountPart);

    Page<User> findByReportcntGreaterThanEqual(Pageable pageable, Long reportcnt);
}
