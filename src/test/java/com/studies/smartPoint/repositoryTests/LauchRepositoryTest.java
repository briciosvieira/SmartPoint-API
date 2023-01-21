package com.studies.smartPoint.repositoryTests;


import com.studies.smartPoint.entity.Company;
import com.studies.smartPoint.entity.Employee;
import com.studies.smartPoint.entity.Lauch;
import com.studies.smartPoint.enums.ProfileEnum;
import com.studies.smartPoint.enums.TypeEnum;
import com.studies.smartPoint.repository.CompanyRepository;
import com.studies.smartPoint.repository.EmployeeRepository;
import com.studies.smartPoint.repository.LauchRepository;
import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LauchRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private LauchRepository lauchRepository;

    private Integer employeeId;

    public LauchRepositoryTest() {
    }

    @Before
    public void setUp() throws Exception{
        Company company = this.companyRepository.save(getCompanyData());

        Employee employee = this.employeeRepository.save(getEmployeeData(company));
        this.employeeId = employee.getId();
    }

    @After
    public void tearDown()throws Exception{
        this.companyRepository.deleteAll();
    }

    @Test
    public void testGetLauchByEmployeeId(){
        List<Lauch> lauches = this.lauchRepository.findByEmployeeId(employeeId);
        assertEquals(0,lauches.size());
    }

    @Test
    public void testGetLauchByEmployeePage(){
        Pageable pageable = PageRequest.of(0, 10, Sort.unsorted());
        Page<Lauch> lauches = this.lauchRepository.findByEmployeeId(employeeId,pageable);
        assertEquals(0,lauches.getTotalElements());
    }

    private Lauch getLauchData(Employee employee){
        Lauch lauch = new Lauch();
        lauch.setDate(new Date());
        lauch.setType(TypeEnum.INICIO_PAUSA);
        lauch.setEmployee(employee);
        return lauch;
    }

    private Employee getEmployeeData(Company company) throws NoSuchAlgorithmException {
        Employee employee = new Employee();
        employee.setName("Fabricio");
        employee.setProfileEnum(ProfileEnum.ROLE_USUARIO);
        employee.setPassword("123456");
        employee.setCpf("123.123.123.99");
        employee.setEmail("fabricio@test.com");
        employee.setCompany(company);
        return employee;

    }

    private Company getCompanyData(){
        Company company = new Company();
        company.setCorporateName("Unidev");
        company.setCnpj("51436645000100");
        return company;
    }
}
