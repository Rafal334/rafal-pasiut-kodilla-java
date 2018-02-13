package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManyToManyFacade {

    private CompanyDao companyDao;
    private EmployeeDao employeeDao;

    public ManyToManyFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> findCompaniesWithNameLike(String name) {
        return companyDao.findCompaniesWithNameLike(name);
    }

    public List<Employee> findEmployeesWithNameLike(String name) {
        return employeeDao.findEmployeesWithNameLike(name);
    }

    public void addCompany(CompanyDto company){
        companyDao.save(new Company(company.getName()));
    }

    public void addEmployee(EmployeeDto employee){
        employeeDao.save(new Employee(employee.getFirstName(),employee.getLastName()));
    }
}
