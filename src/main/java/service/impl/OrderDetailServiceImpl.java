package service.impl;

import DAO.impl.OrderDetailDAOImpl;
import model.OrderDetail;
import service.IOderDetailService;

import java.util.List;


public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail> implements IOderDetailService {
    OrderDetailDAOImpl orderDetailDAO = new OrderDetailDAOImpl();

    @Override
    public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {
        return orderDetailDAO.getOrderDetailsByOrderId(orderId);
    }

    @Override
    public List<OrderDetail> getOrderDetailsByUserId(int userId) {
        return orderDetailDAO.getOrderDetailsByUserId(userId);
    }
}
