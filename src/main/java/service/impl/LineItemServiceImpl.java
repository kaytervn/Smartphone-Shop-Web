package service.impl;

import DAO.impl.LineItemDAOImpl;
import DAO.impl.UserDAOImpl;
import model.LineItem;
import service.ILineItemService;

public class LineItemServiceImpl extends BaseServiceImpl<LineItem> implements ILineItemService {
    LineItemDAOImpl lineItemDAO = new LineItemDAOImpl();

    @Override
    public LineItem findLineItemByProduct(int product_id) {
        return lineItemDAO.findLineItemByProduct(product_id);
    }
}
