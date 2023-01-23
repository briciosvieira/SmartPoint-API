package com.studies.smartPoint.service;

import com.studies.smartPoint.entity.Company;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface CompanyService {
    Optional<Company> searchPorCnpj(String cnpj) ;

    Company persist(Company company) ;


}
