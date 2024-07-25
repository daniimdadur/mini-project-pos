package org.project.pos.form.products.service;

import org.project.pos.form.products.model.ProductReq;
import org.project.pos.form.products.model.ProductRes;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductRes> geAll();
    Optional<ProductRes> getById(Integer id);
    Optional<ProductRes> save(ProductReq request);
    Optional<ProductRes> update(ProductReq request, Integer id);
    Optional<ProductRes> delete(Integer id);
}
