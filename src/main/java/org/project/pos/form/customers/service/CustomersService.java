package org.project.pos.form.customers.service;

import org.project.pos.form.customers.model.CustomersReq;
import org.project.pos.form.customers.model.CustomersRes;

import java.util.List;
import java.util.Optional;

public interface CustomersService {
    List<CustomersRes> getAll();
    Optional<CustomersRes> getById(String id);
    Optional<CustomersRes> add(CustomersReq request);
    Optional<CustomersRes> update(CustomersReq request, String id);
    Optional<CustomersRes> delete(String id);
}
