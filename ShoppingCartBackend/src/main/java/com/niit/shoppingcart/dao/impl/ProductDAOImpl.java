package com.niit.shoppingcart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Product get(int productId) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
	}

	@Transactional
	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}

	@Transactional
	public boolean isProduct(Product product) {
		try {
			String hql = "from product WHERE productName='" + product.getProductName() + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Product> productList = (List<Product>) query.list();
			if (productList != null && !productList.isEmpty()) {
				if (productList.size() >= 1) {
					return true;
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public boolean isUpdateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public List<Product> getProducts() {
		String hql = "from Product product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> productList = (List<Product>) query.list();
		return productList;
	}

	@Transactional
	public Product getProduct(Product product) {
		try {
			String hql = "from product WHERE productName='" + product.getProductName() + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Product> productList = (List<Product>) query.list();
			if (productList != null && !productList.isEmpty()) {
				return productList.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public List<Product> getProducts(int categoryId) {
		try {
			String hql = "from Product product WHERE categoryId="+categoryId+"";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Product> productList = (List<Product>) query.list();
			return productList;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

}
