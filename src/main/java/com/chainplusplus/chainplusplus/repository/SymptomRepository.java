package com.chainplusplus.chainplusplus.repository;

import com.chainplusplus.chainplusplus.model.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Long> {

    @Query(value = "select s.name from symptoms s\n" +
            "inner join disease_symptoms ds on s.id = ds.symptom_id\n" +
            "where ds.disease_id in (select d.id from diseases d\n" +
            "                        where name = ?1)", nativeQuery = true)
    List<String> findAllSymptomsByDisease(String name);

}
