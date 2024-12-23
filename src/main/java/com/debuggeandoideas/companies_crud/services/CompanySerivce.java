package com.debuggeandoideas.companies_crud.services;

import com.debuggeandoideas.companies_crud.entities.Company;

public interface CompanySerivce {

    Company readByName(String name);
    Company create(Company company);
    Company update(Company company, String name);
    void delete(String name);


}
