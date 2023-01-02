package com.studies.smartPoint.repository;

import com.studies.smartPoint.entity.Lauch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LauchRepository extends JpaRepository<Lauch,Integer> {
}
