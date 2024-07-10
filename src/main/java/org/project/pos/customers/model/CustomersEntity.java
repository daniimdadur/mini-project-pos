package org.project.pos.customers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_customers")
public class CustomersEntity {

    @Id
    @Column
    private String id;

    @Column(name = "name")
    private String name;

    private String country;
}
