package com.spring.codeplace.comment.repository;


import com.spring.codeplace.comment.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "select * from CPCOMMENT c where targetoid =:targetoid", nativeQuery = true)
    //Page<Comment> findALLbyTargetoid(Pageable pageable, @Param("tagetoid") Long tagetoid);
    List<Comment> findALLbyTargetoid(@Param("targetoid") Long targetoid);
}
