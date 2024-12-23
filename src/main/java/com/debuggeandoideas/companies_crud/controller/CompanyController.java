package com.debuggeandoideas.companies_crud.controller;

import com.debuggeandoideas.companies_crud.entities.Company;
import com.debuggeandoideas.companies_crud.services.CompanySerivce;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping(path = "company")
@Slf4j
@Tag(name = "Companies resources", description = "Company API")
public class CompanyController {

    private final CompanySerivce companyService;

    @Operation(summary = "Get all companies")
    @GetMapping(path = "{name}")
    public ResponseEntity<Company> get(@PathVariable String name) {
        log.info("GET /company/{}", name);
        return ResponseEntity.ok(this.companyService.readByName(name));
    }

    @Operation(summary = "Post in db company")
    @PostMapping
    public ResponseEntity<Company> post(@RequestBody Company company) {
        log.info("POST /company{}", company.getName());
        return ResponseEntity.created(URI.create(this.companyService.create(company).getName())).build();
    }

    @Operation(summary = "Update in db company")
    @PutMapping(path = "{name}")
    public ResponseEntity<Company> put(@RequestBody Company company,
                                       @PathVariable String  name) {
        log.info("PUT /company/{}", company.getName());
        return ResponseEntity.ok(this.companyService.update(company, name));
    }

    @Operation(summary = "Deleted in db company")
    @DeleteMapping(path = "{name}")
    public ResponseEntity<?> delete(@PathVariable String name) {
        log.info("DELETE /company/{}", name);
        this.companyService.delete(name);
        return ResponseEntity.noContent().build();
    }



}
