package DAO;

import model.Order;

import java.util.List;

public interface IOrderDAO {
    List<Order> getOrderListByUserId(int userId);
}
