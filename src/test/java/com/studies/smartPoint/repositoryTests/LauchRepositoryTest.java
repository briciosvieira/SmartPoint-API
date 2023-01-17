package com.studies.smartPoint.repositoryTests;

import com.studies.smartPoint.entity.Company;
import com.studies.smartPoint.repository.CompanyRepository;
import com.studies.smartPoint.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LauchRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;

    public LauchRepositoryTest() {
    }

    private static final String EMAIL = "email@test.com";
    private static final String CPF = "12345678900";

    @Before
    public void setUp() throws Exception{
        Company company = this.companyRepository.save(getCompanyData());
        this.employeeRepository.save(getEmployeeData());
    }
}
