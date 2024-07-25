package org.project.pos.order.service;

import org.project.pos.order.model.OrderReq;
import org.project.pos.order.model.OrderRes;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderRes> getAll();
    Optional<OrderRes> getById(Integer id);
    Optional<OrderRes> add(OrderReq request);
    Optional<OrderRes> update(OrderReq request, Integer id);
    Optional<OrderRes> delete(Integer id);
}
