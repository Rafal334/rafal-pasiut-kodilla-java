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

    public List<Employee> finEmployeesWithNameLike(String name) {
        return employeeDao.findEmployeesWithNameLike(name);
    }

    public void addCompany(Company company){
        companyDao.save(company);
    }

    public void addEmployee(Employee employee){
        employeeDao.save(employee);
    }
}
