package com.studies.smartPoint.repository;

import com.studies.smartPoint.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer > {
    Employee findByCpf(String cpf);
    Employee findByEmail(String email);
    Employee findByCpfOrEmail(String cpf, String email);
}
