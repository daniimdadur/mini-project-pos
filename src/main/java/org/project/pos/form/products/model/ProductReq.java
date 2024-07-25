package org.project.pos.form.products.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductReq {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("category")
    private Integer category;

    @JsonProperty("stock")
    private Integer stock;

    @JsonProperty("sku")
    private Integer sku;

    @JsonProperty("price")
    private String price;

    @JsonProperty("qty")
    private Integer qty;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("image")
    private String image;

    @JsonProperty("product_brand")
    private String productBrand;
}
