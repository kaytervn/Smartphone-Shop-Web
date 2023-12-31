package DAO.impl;

import DAO.IBaseDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtility;

import java.util.List;

public class BaseDAOImpl<E> implements IBaseDAO<E> {
	@SuppressWarnings("deprecation")
	@Override
	public void insert(E e) {
		Transaction transaction = null;
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(e);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void update(E e) {
		Transaction transaction = null;
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			session.update(e);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}finally {
			session.close();
		}
	}

	@SuppressWarnings({ "deprecation", "hiding" })
	@Override
	public <E> void delete(Class<E> entityClass, int id) {
		Transaction transaction = null;
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			E e = session.get(entityClass, id);
			if (e != null) {
				session.delete(e);
			}
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("hiding")
	@Override
	public <E> E findById(Class<E> entityClass, int id) {
		Transaction transaction = null;
		Session session = HibernateUtility.getSessionFactory().openSession();
		E entityClass1 = null;
		try {
			transaction = session.beginTransaction();
			entityClass1 = session.get(entityClass, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return entityClass1;

	}

	@SuppressWarnings({ "deprecation", "unchecked", "hiding" })
	@Override
	public <E> List<E> getAll(Class<E> entityClass) {
		Transaction transaction = null;
		List<E> listOfe = null;
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			listOfe = session.createQuery("from " + entityClass.getSimpleName()).getResultList();
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
		return listOfe;
	}

}
