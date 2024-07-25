package org.project.pos.form.products.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.pos.form.products.repo.ProductRepo;
import org.project.pos.form.products.model.ProductEntity;
import org.project.pos.form.products.model.ProductReq;
import org.project.pos.form.products.model.ProductRes;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public List<ProductRes> geAll() {
        List<ProductEntity> result = productRepo.findAll();
        if (result.isEmpty()) {
            return Collections.emptyList();
        }
        return result.stream().map(ProductRes::new).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductRes> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductRes> save(ProductReq request) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductRes> update(ProductReq request, Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductRes> delete(Integer id) {
        return Optional.empty();
    }
}
