package com.studies.smartPoint.repository;

import com.studies.smartPoint.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {

    Company findBycnpj(String cnpj);

}
