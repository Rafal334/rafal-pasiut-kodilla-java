package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyDao extends CrudRepository<Company, Integer> {

}
