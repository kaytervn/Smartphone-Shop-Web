package service;

import model.OrderDetail;

import java.util.List;

public interface IOderDetailService {
    public List<OrderDetail> getOrderDetailsByOrderId(int orderId);
    public List<OrderDetail> getOrderDetailsByUserId(int userId);
}
