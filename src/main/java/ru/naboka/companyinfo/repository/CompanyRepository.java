package ru.naboka.companyinfo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.naboka.companyinfo.database.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository <Company, Integer>  {
    @Query(value = "select c from company c where upper(c.fullName) like %?1%")
    Page<Company> findByFullName(String filter, Pageable pageable);

    Page<Company> findAll(Pageable pageable);

}
