package com.niit.shoppingcart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void createSupplier(Supplier supplier) {
		sessionFactory.getCurrentSession().save(supplier);
	}

	@Transactional
	public boolean updateSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public boolean deleteSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public boolean isSupplier(Supplier supplier) {
		try {
			String hql = "from Supplier supplier where supplierId='" + supplier.getSupplierId() + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Supplier> supplierList = (List<Supplier>) query.list();
			if (supplierList != null && !supplierList.isEmpty()) {
				if (supplierList.size() >= 1) {
					return true;
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public List<Supplier> getSuppliers() {
		String hql = "from Supplier supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Supplier> supplierList = (List<Supplier>) query.list();
		return supplierList;
	}

}
