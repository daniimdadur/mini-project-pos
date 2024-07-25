package org.project.pos.form.category.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.pos.form.category.model.CategoryEntity;
import org.project.pos.form.category.model.CategoryReq;
import org.project.pos.form.category.model.CategoryRes;
import org.project.pos.form.category.repo.CategoryRepo;
import org.project.pos.exception.PosException;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public List<CategoryRes> getAll() {
        List<CategoryEntity> result = this.categoryRepo.findAll();
        if (result.isEmpty()){
            return Collections.emptyList();
        }
        return result.stream().map(CategoryRes::new).collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryRes> getById(String id) {
        CategoryEntity result = this.getEntityById(id);

        return Optional.of(this.convertEntityToRes(result));
    }

    @Override
    public Optional<CategoryRes> save(CategoryReq request) {
        CategoryEntity categoryEntity = new CategoryEntity();

        BeanUtils.copyProperties(request, categoryEntity);
        try {
            this.categoryRepo.save(categoryEntity);
            log.info("save category to database succes");
            return Optional.of(new CategoryRes(categoryEntity));
        }catch (Exception e) {
            log.error("save category to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoryRes> update(CategoryReq request, String id) {
        CategoryEntity categoryEntity = this.categoryRepo.findById(id).orElse(null);
        if (categoryEntity == null){
            log.info("category with id: {} not found", id);
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, categoryEntity);
        try {
            this.categoryRepo.save(categoryEntity);
            log.info("update gedung to database success");
            return Optional.of(new CategoryRes(categoryEntity));
        } catch (Exception e){
            log.error("update category to database failed, error: {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoryRes> delete(String id) {
        return Optional.empty();
    }

    private CategoryRes convertEntityToRes(CategoryEntity entity) {
        CategoryRes result = new CategoryRes();
        BeanUtils.copyProperties(entity, result);
        return result;
    }

    private CategoryEntity getEntityById(String id) {
        CategoryEntity result = categoryRepo.findById(id).orElse(null);
        if (result == null) {
            Map<String, String> errors = Map.of("kode", "kode" + id + "tidak dapat ditemukan");
            throw new PosException(HttpStatus.BAD_REQUEST, errors);
        }
        return result;
    }

    private CategoryEntity convertReqToEntity(CategoryReq request) {
        CategoryEntity result = new CategoryEntity();
        BeanUtils.copyProperties(request, result);
        return result;
    }
}
