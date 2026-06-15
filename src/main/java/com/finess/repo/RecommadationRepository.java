package com.finess.repo;

import com.finess.model.Recommadation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommadationRepository extends JpaRepository<Recommadation,String> {
    List<Recommadation> findByUserId(String userId);

    List<Recommadation> findByActivityId(String activityId);
}
