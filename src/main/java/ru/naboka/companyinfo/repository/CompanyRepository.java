package ru.naboka.companyinfo.repository;

import ru.naboka.companyinfo.database.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends org.springframework.data.repository.Repository<Company, Integer>  {
    Optional<Company> findById (Integer id);
    List<Company> findAllByFullNameContains = null;

}
