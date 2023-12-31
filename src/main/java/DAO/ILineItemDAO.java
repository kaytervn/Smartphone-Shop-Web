package DAO;

import model.LineItem;

public interface ILineItemDAO {
    public LineItem findLineItemByProduct(int product_id);
}
