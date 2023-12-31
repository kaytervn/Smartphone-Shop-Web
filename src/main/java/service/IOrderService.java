package service;

import model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getOrderListByUserId(int userId);
}
