package org.project.pos.form.products.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.pos.form.products.repo.ProductRepo;
import org.project.pos.form.products.model.ProductEntity;
import org.project.pos.form.products.model.ProductReq;
import org.project.pos.form.products.model.ProductRes;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
            log.info("No products found");
            return Collections.emptyList();
        }
        return result.stream().map(ProductRes::new).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductRes> getById(String id) {
        ProductEntity productEntity = this.productRepo.findById(id).orElse(null);
        if (productEntity == null) {
            log.info("Product with id {} not found", id);
            return Optional.empty();
        }

        ProductRes productRes = new ProductRes(productEntity);
        return Optional.of(productRes);
    }

    @Override
    public Optional<ProductRes> save(ProductReq request) {
        ProductEntity productEntity = new ProductEntity();

        BeanUtils.copyProperties(request, productEntity);
        productEntity.setId(UUID.randomUUID().toString());
        try {
            this.productRepo.save(productEntity);
            log.info("Save Product to Databases Success");
            return Optional.of(new ProductRes(productEntity));
        } catch (Exception e) {
            log.error("Save Product to Databases Failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductRes> update(ProductReq request, String id) {
        ProductEntity result = this.productRepo.findById(id).orElse(null);
        if (result == null) {
            log.info("product with id {} not found", id);
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, result);
        try {
            this.productRepo.save(result);
            log.info("update product to databases success");
            return Optional.of(new ProductRes(result));
        } catch (Exception e) {
            log.error("update product to databases failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductRes> delete(String id) {
        ProductEntity result = this.productRepo.findById(id).orElse(null);
        if (result == null) {
            log.warn("product with id {} not found", id);
            return Optional.empty();
        }
        try {
            this.productRepo.delete(result);
            log.info("delete product from databases success");
            return Optional.of(new ProductRes(result));
        } catch (Exception e) {
            log.error("delete product from databases failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
