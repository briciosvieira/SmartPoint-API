package com.studies.smartPoint.repositoryTests;

import com.studies.smartPoint.entity.Company;
import com.studies.smartPoint.repository.CompanyRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CompanyRepositoryTest {
    @Autowired
    private CompanyRepository companyRepository;

    private static final String CNPJ= "5143646450000100";

    @Before
    public void setUp() throws Exception {
        Company company = new Company();
        company.setCorporateName("Unidev");
        company.setCnpj(CNPJ);
        this.companyRepository.save(company);
    }

    @After
    public final void tearDown(){
        this.companyRepository.deleteAll();
    }

    @Test
    public void testSearchCnpj() {
        Company company = this.companyRepository.findBycnpj(CNPJ);
        assertEquals(CNPJ , company.getCnpj());
    }

}
