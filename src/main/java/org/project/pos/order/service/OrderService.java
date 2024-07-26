package org.project.pos.order.service;

import org.project.pos.order.model.OrderReq;
import org.project.pos.order.model.OrderRes;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderRes> getAll();
    Optional<OrderRes> getById(String id);
    Optional<OrderRes> add(OrderReq request);
    Optional<OrderRes> update(OrderReq request, String id);
    Optional<OrderRes> delete(String id);
}
