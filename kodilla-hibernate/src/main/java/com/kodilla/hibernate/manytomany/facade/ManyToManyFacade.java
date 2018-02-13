package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManyToManyFacade {

    private CompanyDao companyDao;
    private EmployeeDao employeeDao;
    private Mapper mapper;

    public ManyToManyFacade(CompanyDao companyDao, EmployeeDao employeeDao, Mapper mapper) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
        this.mapper = mapper;
    }

    public List<CompanyDto> findCompaniesWithNameLike(String name) {
        return mapper.companiesToCompanyDtos(companyDao.findCompaniesWithNameLike(name));
    }

    public List<EmployeeDto> findEmployeesWithNameLike(String name) {
        return mapper.employeesToEmployeeDtos(employeeDao.findEmployeesWithNameLike(name));
    }

    public void addCompany(CompanyDto company){
        companyDao.save(mapper.companyDtoToCompany(company));
    }

    public void addEmployee(EmployeeDto employee){
        employeeDao.save(mapper.employeeDtoToEmployee(employee));
    }
}
