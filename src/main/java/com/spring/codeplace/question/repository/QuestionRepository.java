package com.spring.codeplace.question.repository;

import com.spring.codeplace.question.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "select * from CPDOCUMENT WHERE tag =:tag", nativeQuery = true)
    Page<Question> findAllByTag(Pageable pageable, @Param("tag") String tag);

    @Query(value = "select tag from CPDOCUMNET", nativeQuery = true)
    List<String> findAllTag();

}
