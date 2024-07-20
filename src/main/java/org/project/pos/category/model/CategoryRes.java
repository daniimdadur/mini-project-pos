package org.project.pos.category.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRes {

    private String id;
    private String name;
    private Integer totalProducts;
    private Integer totalEarnings;
public CategoryRes(CategoryEntity categoryEntity) {
    BeanUtils.copyProperties(categoryEntity, this);
}

}
