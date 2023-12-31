package DAO.impl;

import DAO.IUserDAO;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtility;

@SuppressWarnings("rawtypes")
public class UserDAOImpl extends BaseDAOImpl implements IUserDAO {

	@Override
	public User findByEmail(String email) {
		Transaction transaction = null;
		Session session = HibernateUtility.getSessionFactory().openSession();
		User user = null;
		try {
			transaction = session.beginTransaction();
			String hql = "FROM User WHERE email = :email";
			user = session.createQuery(hql, User.class).setParameter("email", email).uniqueResult();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();

		}finally {
			session.close();
		}
		return user;
	}

	@Override
	public boolean checkExistEmail(String email) {
		Transaction transaction = null;
		Session session = HibernateUtility.getSessionFactory().openSession();
		boolean exists = false;
		try {
			transaction = session.beginTransaction();
			String hql = "SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email = :email";
			exists = session.createQuery(hql, Boolean.class).setParameter("email", email).uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		return exists;
	}

	@Override
	public boolean checkExistPhone(String phoneNumber) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean exists = false;
		try {
			transaction = session.beginTransaction();
			String hql = "SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.phoneNumber = :phoneNumber";
			exists = session.createQuery(hql, Boolean.class).setParameter("phoneNumber", phoneNumber)
					.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();

		}finally {
			session.close();
		}
		return exists;
	}
}
