package com.chainplusplus.chainplusplus.repository;

import com.chainplusplus.chainplusplus.dto.ActivityDTO;
import com.chainplusplus.chainplusplus.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query(value = "select new com.chainplusplus.chainplusplus.dto.ActivityDTO(a.activity, a.frequency, a.dimension) from Activity a\n" +
            "inner join a.answers aa where aa.id in (select ans.id from Answer ans where ans.answer = ?1 )")
    List<ActivityDTO> findAllActivitiesByAnswer(String answer);

    @Query(value = "select new com.chainplusplus.chainplusplus.dto.ActivityDTO(a.activity, a.frequency, a.dimension) from Activity a\n" +
            "inner join a.symptoms ss where ss.id in (select sym.id from Symptom sym where sym.name = ?1 )")
    List<ActivityDTO> findAllActivitiesBySymptom(String name);

}
