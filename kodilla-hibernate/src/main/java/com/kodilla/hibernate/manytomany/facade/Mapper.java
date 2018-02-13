package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {

    public Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getFirstName(), employeeDto.getLastName());
    }

    public EmployeeDto employeeToEmployeeDto(Employee employee) {
        return new EmployeeDto(employee.getFirstname(), employee.getFirstname());
    }

    public Company companyDtoToCompany(CompanyDto companyDto) {
        return new Company(companyDto.getName());
    }

    public CompanyDto companyToCompanyDto(Company company) {
        return new CompanyDto(company.getName());
    }

    public List<CompanyDto> companiesToCompanyDtos(List<Company> companies) {
        List<CompanyDto> companyDtos = new ArrayList<>();
        companies.stream().forEach(company -> companyDtos.add(companyToCompanyDto(company)));
        return companyDtos;
    }

    public List<EmployeeDto> employeesToEmployeeDtos(List<Employee> employees) {
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        employees.stream().forEach(employee -> employeeDtos.add(employeeToEmployeeDto(employee)));
        return employeeDtos;
    }
}
