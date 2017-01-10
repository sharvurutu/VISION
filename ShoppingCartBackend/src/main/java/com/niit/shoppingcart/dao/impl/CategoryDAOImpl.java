package com.niit.shoppingcart.dao.impl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional

	public Category get(String id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Transactional
	public boolean delete(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public List<Category> list() {
		String hql = "from Category category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
	}

	@Transactional
	public boolean delete(String id) {
		boolean isValid = false;
		try {
			int result = sessionFactory.getCurrentSession().createQuery("from Category category where id='"+id+"'").executeUpdate();
		    if(result == 1){
		    	isValid = true;
		    }
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return isValid;
	}

	@Transactional
	public boolean isCategory(Category category) {
		try {
			String sql = "from Category category where name='"+category.getName()+"'";
			Query query = sessionFactory.getCurrentSession().createQuery(sql);
			List<Category> categoryList = query.list();
			if(categoryList != null && !categoryList.isEmpty()){
				return true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public int getCategoryIdByName(String categoryName){
		int id = 0;
		try {
			String sql = "from Category category where name='"+categoryName+"'";
			Query query = sessionFactory.getCurrentSession().createQuery(sql);
			List<Category> categoryList = query.list();
			if(categoryList != null && !categoryList.isEmpty()){
				for(Category category : categoryList){
					id = Integer.parseInt(category.getId());
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  return id;
	}
} 
