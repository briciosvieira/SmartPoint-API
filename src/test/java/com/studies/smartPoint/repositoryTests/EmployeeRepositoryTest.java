package com.studies.smartPoint.repositoryTests;

import com.studies.smartPoint.entity.Company;
import com.studies.smartPoint.entity.Employee;
import com.studies.smartPoint.enums.ProfileEnum;
import com.studies.smartPoint.repository.CompanyRepository;
import com.studies.smartPoint.repository.EmployeeRepository;
import com.studies.smartPoint.utils.PasswordUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;

    private static final String EMAIL = "test@teste.com";
    private static final String CPF = "12345678900";

    @Before
    public void setUp() throws Exception{
        Company company = this.companyRepository.save(getDataCompany());
        this.employeeRepository.save(getDataEmployee(company));
    }

    @After
    public final void tearDown(){
        this.companyRepository.deleteAll();
    }

    @Test
    public void testFindEmployeeEmail(){
        Employee employee = this.employeeRepository.findByEmail(EMAIL);
        assertEquals(EMAIL, employee.getEmail());
    }

    @Test
    public void testFindEmployeeCpf(){
        Employee employee = this.employeeRepository.findByCpf(CPF);
        assertEquals(CPF, employee.getCpf());
    }

    @Test
    public void testFindEmployeeEmailCpf(){
        Employee employee = this.employeeRepository.findByCpfOrEmail(CPF, EMAIL);
        assertNotNull(employee);
    }

    @Test
    public void testFindEmployeeEmailCpfButInvalidEmail(){
        Employee employee = this.employeeRepository.findByCpfOrEmail(CPF, "tesla123@gmail.com");
        assertNotNull(employee);
    }

    @Test
    public void testFindEmployeeEmailCpfButInvalidCpf(){
        Employee employee = this.employeeRepository.findByCpfOrEmail("12345678988", EMAIL);
        assertNotNull(employee);
    }

    private Employee getDataEmployee(Company company) throws NoSuchAlgorithmException {
        Employee employee = new Employee();
        employee.setName("Fabricio");
        employee.setProfileEnum(ProfileEnum.ROLE_ADMIN);
        employee.setPassword("123456");
        employee.setCpf(CPF);
        employee.setEmail(EMAIL);
        employee.setCompany(company);
        return  employee;
    }

    private Company getDataCompany(){
        Company company = new Company();
        company.setCorporateName("Unidev");
        company.setCnpj("51436364500001");
        return company;
    }

}
