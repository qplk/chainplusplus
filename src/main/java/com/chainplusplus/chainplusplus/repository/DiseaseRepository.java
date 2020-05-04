package com.chainplusplus.chainplusplus.repository;

import com.chainplusplus.chainplusplus.model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {

    Disease getDiseaseByName(String name);

}
