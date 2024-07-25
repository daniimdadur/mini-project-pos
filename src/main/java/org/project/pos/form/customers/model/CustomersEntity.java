package org.project.pos.form.customers.model;

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
@Table(name = "tbl_customers")
public class CustomersEntity {

    @Id
    @Column
    private Integer id;

    @Column(name = "customer")
    private String customerName;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "email")
    private String email;

    @Column(name = "country")
    private String country;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "order")
    private Integer orderCount;

    @Column(name = "total_spent")
    private String totalSpent;

    @Column(name = "image")
    private String image;
}
