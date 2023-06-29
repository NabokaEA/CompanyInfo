package ru.naboka.companyinfo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.naboka.companyinfo.database.entity.Company;
import ru.naboka.companyinfo.repository.CompanyRepository;
import ru.naboka.companyinfo.util.PageSizeValueProvider;

import java.util.Optional;

import static ru.naboka.companyinfo.util.IsNullCheckerProvider.isNull;


public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private PageSizeValueProvider pageSizeValueProvider;

    @Override
    public Page<Company> getAll(Integer pageSize, Integer pageNumber) {
        isNull(pageSize,pageNumber);
        Integer pageSize1 = pageSizeValueProvider.getPageSize(pageSize);
        return companyRepository.findAll(Pageable.ofSize(pageSize1).withPage(pageNumber));
    }

    @Override
    public Page<Company> findByFullName(String filterForName, Integer pageSize, Integer pageNumber) {
        return companyRepository.findByFullName(filterForName.toUpperCase(), Pageable
                .ofSize(pageSize)
                .withPage(pageNumber));
    }

    @Override
    public Optional<Company> getById(Integer id) {
        return companyRepository.findById(id);
    }
}
