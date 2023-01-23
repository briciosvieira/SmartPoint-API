package com.studies.smartPoint.serviceImp;

import com.studies.smartPoint.entity.Company;
import com.studies.smartPoint.repository.CompanyRepository;
import com.studies.smartPoint.service.CompanyService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CompanyServiceImp implements CompanyService{

    private static final Logger log = (Logger) LoggerFactory.getLogger(CompanyServiceImp.class);

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Optional<Company> searchPorCnpj(String cnpj) {
        log.info("Buscar uma empresa para o CNPJ : "+cnpj);
        return Optional.ofNullable(companyRepository.findBycnpj(cnpj));
    }

    @Override
    public Company persist(Company company) {
        log.info("Persistir empresa:" + company);
        return this.companyRepository.save(company);
    }
}
