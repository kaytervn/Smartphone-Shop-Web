package DAO.impl;

import DAO.ILineItemDAO;
import model.LineItem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtility;

import java.util.List;

public class LineItemDAOImpl extends BaseDAOImpl<LineItem> implements ILineItemDAO {

    @Override
    public LineItem findLineItemByProduct(int product_id) {
        Transaction transaction = null;
        Session session = HibernateUtility.getSessionFactory().openSession();
        LineItem lineItem = null;
        try {
            transaction = session.beginTransaction();
            String hql = "FROM LineItem li WHERE li.product.id = :product_id";
            lineItem = session.createQuery(hql, LineItem.class).setParameter("product_id", product_id).uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return lineItem;
    }
}
