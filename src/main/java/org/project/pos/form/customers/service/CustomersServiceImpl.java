package org.project.pos.form.customers.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.pos.form.customers.model.CustomersEntity;
import org.project.pos.form.customers.model.CustomersReq;
import org.project.pos.form.customers.model.CustomersRes;
import org.project.pos.form.customers.repo.CustomersRepo;
import org.springframework.beans.BeanUtils;
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
        CustomersEntity result = this.customersRepo.findById(id).orElse(null);
        if (result == null) {
            log.info("Customer with id {} not found", id);
            return Optional.empty();
        }

        CustomersRes res = new CustomersRes(result);
        return Optional.of(res);
    }

    @Override
    public Optional<CustomersRes> add(CustomersReq request) {
        CustomersEntity customersEntity = new CustomersEntity();

        BeanUtils.copyProperties(request, customersEntity);
        try {
            this.customersRepo.save(customersEntity);
            log.info("save customers to databases success");
            return Optional.of(new CustomersRes(customersEntity));
        } catch (Exception e) {
            log.error("save customers to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomersRes> update(CustomersReq request, String id) {
        CustomersEntity customersEntity = this.customersRepo.findById(id).orElse(null);
        if (customersEntity == null) {
            log.info("customer with id {} not found", id);
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, customersEntity);
        try {
            this.customersRepo.save(customersEntity);
            log.info("update customers to databases success");
            return Optional.of(new CustomersRes(customersEntity));
        } catch (Exception e) {
            log.error("update customers to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomersRes> delete(String id) {
        CustomersEntity customersEntity = this.customersRepo.findById(id).orElse(null);
        if (customersEntity == null) {
            log.warn("customer with id {} not found", id);
            return Optional.empty();
        }
        try {
            this.customersRepo.delete(customersEntity);
            log.info("delete customers to databases success");
            return Optional.of(new CustomersRes(customersEntity));
        } catch (Exception e) {
            log.error("delete customers to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
