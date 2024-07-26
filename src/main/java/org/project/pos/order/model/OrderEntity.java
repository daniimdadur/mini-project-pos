package org.project.pos.order.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_order")
public class OrderEntity {

    @Id
    @Column
    private String id;

    @Column(name = "order_name")
    private Integer order;

    @Column(name = "customer_name")
    private String customer;

    @Column(name = "email")
    private String email;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "payment")
    private Integer payment;

    @Column(name = "status")
    private Integer status;

    @Column(name = "spent")
    private String spent;

    @Column(name = "method")
    private String method;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "method_number")
    private Integer methodNumber;
}
