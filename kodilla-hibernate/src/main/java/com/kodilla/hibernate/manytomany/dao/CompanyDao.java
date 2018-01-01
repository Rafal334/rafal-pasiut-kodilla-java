package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyDao extends CrudRepository<Company, Integer> {

    @Query(value = "SELECT * FROM COMPANIES WHERE SUBSTRING(COMPANY_NAME,1,3) = :NAME_START", nativeQuery = true)
    List<Company> findCompanyStartsWith(@Param("NAME_START") String nameStart);
}
