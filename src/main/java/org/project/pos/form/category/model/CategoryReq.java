package org.project.pos.form.category.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryReq {

    private String id;
    private String name;
    private Integer totalProducts;
    private Integer totalEarnings;
}
