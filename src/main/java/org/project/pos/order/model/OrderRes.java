package org.project.pos.order.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRes {

    @JsonProperty("id")
    private String id;

    @JsonProperty("order")
    private Integer order;

    @JsonProperty("customer")
    private String customer;

    @JsonProperty("email")
    private String email;

    @JsonProperty("avatar")
    private String avatar;

    @JsonProperty("payment")
    private Integer payment;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("spent")
    private String spent;

    @JsonProperty("method")
    private String method;

    @JsonProperty("date")
    private String date;

    @JsonProperty("time")
    private String time;

    @JsonProperty("method_number")
    private Integer methodNumber;

    public OrderRes(OrderEntity orderEntity) {
        BeanUtils.copyProperties(orderEntity, this);
    }
}
