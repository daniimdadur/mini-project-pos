package org.project.pos.form.category.repo;

import org.project.pos.form.category.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, String> {
//    List<CategoryEntity> findAllByStatus(DataStatus status);
//    int countByStatus(DataStatus status);
    //int count();
}
