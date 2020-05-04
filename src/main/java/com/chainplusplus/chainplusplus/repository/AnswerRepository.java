package com.chainplusplus.chainplusplus.repository;

import com.chainplusplus.chainplusplus.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query(value = "select a.answer from answers a\n" +
            "where symptom = ?1", nativeQuery = true)
    List<String> findAllAnswersForSymptom(String symptom);
}
