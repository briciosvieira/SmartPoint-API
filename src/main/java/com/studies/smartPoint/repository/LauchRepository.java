package com.studies.smartPoint.repository;

import com.studies.smartPoint.entity.Lauch;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@NamedQueries({@NamedQuery(name = "lauchRepository.findByEmployeeId",query = "SELECT lauc FROM lauch lauc WHERE lauc.employee.id = :employeeId")})

@Repository
public interface LauchRepository extends JpaRepository<Lauch,Integer> {
    List<Lauch> findByEmployeeId(@Param("employeeId") Integer employeeId);
    Page<Lauch> findByEmployeeId(@Param("employeeId") Integer employeeId, Pageable pageable);

}
