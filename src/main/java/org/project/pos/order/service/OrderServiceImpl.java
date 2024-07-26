package org.project.pos.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.Order;
import org.project.pos.order.model.OrderEntity;
import org.project.pos.order.model.OrderReq;
import org.project.pos.order.model.OrderRes;
import org.project.pos.order.repo.OrderRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService{
    private final OrderRepo orderRepo;

    @Override
    public List<OrderRes> getAll() {
        List<OrderEntity> result = this.orderRepo.findAll();
        if (result.isEmpty()) {
            return Collections.emptyList();
        }
        return result.stream().map(OrderRes::new).collect(Collectors.toList());
    }

    @Override
    public Optional<OrderRes> getById(String id) {
        OrderEntity result = this.orderRepo.findById(id).orElse(null);
        if (result == null) {
            log.info("order with id {} not found", id);
            return Optional.empty();
        }

        OrderRes orderRes = new OrderRes(result);
        return Optional.of(orderRes);
    }

    @Override
    public Optional<OrderRes> add(OrderReq request) {
        OrderEntity result = new OrderEntity();

        BeanUtils.copyProperties(request, result);
        try {
            this.orderRepo.save(result);
            log.info("save order to databases success");
            return Optional.of(new OrderRes(result));
        } catch (Exception e) {
            log.error("save order to databases failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<OrderRes> update(OrderReq request, String id) {
        OrderEntity result = this.orderRepo.findById(id).orElse(null);
        if (result == null) {
            log.info("Order with id {} not found", id);
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, result);
        try {
            this.orderRepo.save(result);
            log.info("update order to databases success");
            return Optional.of(new OrderRes(result));
        } catch (Exception e) {
            log.error("update order to databases failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<OrderRes> delete(String id) {
        OrderEntity result = this.orderRepo.findById(id).orElse(null);
        if (result == null) {
            log.warn("order with id {} not found", id);
            return Optional.empty();
        }
        try {
            this.orderRepo.delete(result);
            log.info("delete order from databases success");
            return Optional.of(new OrderRes(result));
        } catch (Exception e) {
            log.error("delete order from databases failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
