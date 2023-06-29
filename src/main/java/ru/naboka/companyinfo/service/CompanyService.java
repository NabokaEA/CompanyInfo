package ru.naboka.companyinfo.service;

import org.springframework.data.domain.Page;
import ru.naboka.companyinfo.database.entity.Company;

import java.util.Optional;

public interface CompanyService {

    Page<Company> getAll(Integer pageSize, Integer pageNumber);

    Page<Company> findByFullName(String filterForName, Integer pageSize, Integer pageNumber);

    Optional<Company> getById(Integer id);
}
