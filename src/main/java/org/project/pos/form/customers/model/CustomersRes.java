package org.project.pos.form.customers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomersRes {

    @JsonProperty("id")
    private String id;

    @JsonProperty("customer")
    private String customerName;

    @JsonProperty("customer_id")
    private Integer customerId;

    @JsonProperty("email")
    private String email;

    @JsonProperty("country")
    private String country;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("order")
    private Integer orderCount;

    @JsonProperty("total_spent")
    private String totalSpent;

    @JsonProperty("image")
    private String image;

    public CustomersRes(CustomersEntity customersEntity) {
        BeanUtils.copyProperties(customersEntity, this);
//        this.id = customersEntity.getId();
//        this.customerName = customersEntity.getCustomerName();
//        this.customerId = customersEntity.getCustomerId();
//        this.email = customersEntity.getEmail();
//        this.country = customersEntity.getCountry();
//        this.countryCode = customersEntity.getCountryCode();
//        this.orderCount = customersEntity.getOrderCount();
//        this.totalSpent = customersEntity.getTotalSpent();
//        this.image = customersEntity.getImage();
    }
}
