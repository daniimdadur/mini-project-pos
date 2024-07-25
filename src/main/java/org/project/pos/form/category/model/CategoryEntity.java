package org.project.pos.form.category.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_category")
public class CategoryEntity {

    @Id
    @Column
    private Integer id;

    @Column(name = "cat_image")
    private String catImage;

    @Column(name = "categories")
    private String categories;

    @Column(name = "category_detail")
    private String categoryDetail;

    @Column(name = "total_earnings")
    private String totalEarnings;

    @Column(name = "total_products")
    private Integer totalProducts;

//    @Builder.Default
//    @Column(name = "category_status")
//    private DataStatus status = DataStatus.ACTIVE;
}
