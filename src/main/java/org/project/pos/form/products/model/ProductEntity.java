package org.project.pos.form.products.model;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_product")
public class ProductEntity {

    @Id
    @Column
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "category")
    private Integer category;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "sku")
    private Integer sku;

    @Column(name = "price")
    private String price;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "status")
    private Integer status;

    @Column(name = "image")
    private String image;

    @Column(name = "product_brand")
    private String productBrand;
}
