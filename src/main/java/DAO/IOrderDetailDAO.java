package DAO;

import model.OrderDetail;

import java.util.List;

public interface IOrderDetailDAO {
    List<OrderDetail> getOrderDetailsByOrderId(int orderId);
    List<OrderDetail> getOrderDetailsByUserId(int userId);
}
