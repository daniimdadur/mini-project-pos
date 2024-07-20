package org.project.pos.category.model;

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
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "total_products")
    private Integer totalProducts;

    @Column(name = "total_earnigs")
    private Integer totalEarnings;

//    @Builder.Default
//    @Column(name = "category_status")
//    private DataStatus status = DataStatus.ACTIVE;
}
