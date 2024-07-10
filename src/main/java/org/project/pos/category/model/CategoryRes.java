package org.project.pos.category.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.pos.constan.DataStatus;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRes {

    private String id;
    private String name;
    private String totalProducts;
    private String totalEarnings;
    private DataStatus status;

    public CategoryRes(CategoryEntity categoryEntity) {
        BeanUtils.copyProperties(categoryEntity, this);
    }
}
