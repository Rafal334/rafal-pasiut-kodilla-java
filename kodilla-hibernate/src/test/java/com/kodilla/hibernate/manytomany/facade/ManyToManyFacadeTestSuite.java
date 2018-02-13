package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ManyToManyFacadeTestSuite {

    @Autowired
    ManyToManyFacade facade;

    @Test
    public void testFindCompaniesWithNameLike(){
        //Given
        facade.addCompany(new Company("ABC International"));
        facade.addCompany(new Company("Software ABCxx"));
        facade.addCompany(new Company("Corporate AB"));

        //When
        List<Company> companiesABC = facade.findCompaniesWithNameLike("ABC");
        List<Company> companiesAB = facade.findCompaniesWithNameLike("xx");
        List<Company> emptyCompanies = facade.findCompaniesWithNameLike("test");

        //Then
        Assert.assertEquals(2,companiesABC.size());
        Assert.assertEquals(1,companiesAB.size());
        Assert.assertTrue(emptyCompanies.isEmpty());
    }

    @Test
    public void testFindEmployeesWithNameLike(){
        //Given
        facade.addEmployee(new Employee("Jan", "Kowalski"));
        facade.addEmployee(new Employee("Robert", "Nowak"));
        facade.addEmployee(new Employee("Bogdan", "Kosturkiewicz"));
        facade.addEmployee(new Employee("Tadeusz", "Nowakowski"));

        //When
        List<Employee> employeesNowak= facade.finEmployeesWithNameLike("Nowak");
        List<Employee> employeesSki = facade.finEmployeesWithNameLike("ski");
        List<Employee> employessTurk = facade.finEmployeesWithNameLike("turk");
        List<Employee> noEmployees = facade.finEmployeesWithNameLike("test");

        //Then
        Assert.assertEquals(2,employeesNowak.size());
        Assert.assertEquals(2,employeesSki.size());
        Assert.assertEquals(1,employessTurk.size());
        Assert.assertTrue(noEmployees.isEmpty());
    }
}
