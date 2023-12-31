package DAO.impl;

import DAO.ICartDAO;
import model.Cart;
import model.LineItem;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtility;

import java.util.List;

public class CartDAOImpl extends BaseDAOImpl<Cart> implements ICartDAO {
    @Override
    public Cart findByUser(User user) {
        Transaction transaction = null;
        Session session = HibernateUtility.getSessionFactory().openSession();
        Cart cart = null;
        try {
            transaction = session.beginTransaction();
            String hql = "FROM Cart WHERE '"+ user.getEmail()+"' =: user_email";
            cart = session.createQuery(hql, Cart.class).setParameter("user_email", user.getEmail()).uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
        return cart;
    }

    @Override
    public List<LineItem> getAllLineItem(int cart_id) {
        Transaction transaction = null;
        List<LineItem> listOfLineItem = null;
        Session session = HibernateUtility.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            String hql = "FROM LineItem Where cart.id =: cart_id";
            listOfLineItem = session.createQuery(hql).setParameter("cart_id", cart_id).getResultList();
            //System.out.println("List line item DAO =" + listOfLineItem.get(0).getProduct().getName());
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }   finally {
            session.close();
        }

        return listOfLineItem;
    }


}
