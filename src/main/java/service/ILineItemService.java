package service;

import model.LineItem;

public interface ILineItemService {
    public LineItem findLineItemByProduct(int product_id);
}
