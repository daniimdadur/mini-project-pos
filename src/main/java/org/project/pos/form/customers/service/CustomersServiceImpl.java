package org.project.pos.form.customers.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.pos.form.customers.model.CustomersEntity;
import org.project.pos.form.customers.model.CustomersReq;
import org.project.pos.form.customers.model.CustomersRes;
import org.project.pos.form.customers.repo.CustomersRepo;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomersServiceImpl implements CustomersService {
    private final CustomersRepo customersRepo;

    @Override
    public List<CustomersRes> getAll() {
        List<CustomersEntity> result = this.customersRepo.findAll();
        if (result.isEmpty()) {
            return Collections.emptyList();
        }
        return result.stream().map(CustomersRes::new).collect(Collectors.toList());
    }

    @Override
    public Optional<CustomersRes> getById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomersRes> add(CustomersReq request) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomersRes> update(CustomersReq request, String id) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomersRes> delete(String id) {
        return Optional.empty();
    }
}
