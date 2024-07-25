package org.project.pos.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.pos.order.model.OrderEntity;
import org.project.pos.order.model.OrderReq;
import org.project.pos.order.model.OrderRes;
import org.project.pos.order.repo.OrderRepo;
import org.springframework.stereotype.Repository;
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
    public Optional<OrderRes> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<OrderRes> add(OrderReq request) {
        return Optional.empty();
    }

    @Override
    public Optional<OrderRes> update(OrderReq request, Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<OrderRes> delete(Integer id) {
        return Optional.empty();
    }
}
