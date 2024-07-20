package org.project.pos.category.repo;

import org.project.pos.category.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, String> {
//    List<CategoryEntity> findAllByStatus(DataStatus status);
//    int countByStatus(DataStatus status);
    //int count();
}
