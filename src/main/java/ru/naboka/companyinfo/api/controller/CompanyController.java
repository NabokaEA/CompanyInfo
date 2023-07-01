package ru.naboka.companyinfo.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.naboka.companyinfo.api.dto.PageDto;
import ru.naboka.companyinfo.database.entity.Company;
import ru.naboka.companyinfo.service.CompanyService;
import ru.naboka.companyinfo.util.PageSizeValueProvider;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/company",
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
@AllArgsConstructor
public class CompanyController {
    private final PageSizeValueProvider pageSizeValueProvider;
    private final CompanyService companyService;

    @GetMapping(path = {"/getById/{id}"})
    public ResponseEntity<Optional<Company>> getById(
            @PathVariable("id") String id) {
        Optional<Company> company = companyService.getById(Integer.valueOf(id));
        return ResponseEntity.ok(company);
    }

/*    @GetMapping(path = {"/search"}, params = {"filter"})
    public ResponseEntity<Company> search(
            @RequestParam String filter,
            @RequestParam(required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(required = false) Integer pageSize
    ) {
        Integer correctedPageSize = pageSizeValueProvider.getPageSize(pageSize);
        Page<Company> pageOfCompanies = companyService.findByFullName(filter, correctedPageSize, pageNumber);

        return ResponseEntity.ok(new PageDto<>(getCompanyList(pageOfCompanies), pageNumber
                , correctedPageSize, pageOfCompanies.getTotalPages()));
    }*/

 /*   private List<Company> getCompanyList(Page<Company> entityPage) {
        return EntityToDtoConvertor.getDtoList(entityPage.getContent(), Company.class, CompanyDTO.class);
    }*/

    @GetMapping(params = {"pageNumber"})
    public ResponseEntity<PageDto<Company>> get(
            @RequestParam Integer pageNumber,
            @RequestParam(required = false) Integer pageSize) {
        Integer correctedPageSize = pageSizeValueProvider.getPageSize(pageSize);
        Page<Company> pageOfCompanys = companyService.getAll(correctedPageSize, pageNumber);
return (ResponseEntity<PageDto<Company>>) pageOfCompanys;
        /*return ResponseEntity.ok(new PageDto<>(getCompanyList(pageOfCompanys)
                , pageNumber, correctedPageSize, pageOfCompanys.getTotalPages()));*/
    }

}
