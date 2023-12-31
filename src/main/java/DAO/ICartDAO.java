package DAO;

import model.Cart;
import model.LineItem;
import model.User;

import java.util.List;

public interface ICartDAO {
    Cart findByUser(User user);
    List<LineItem> getAllLineItem(int card_id);
}
