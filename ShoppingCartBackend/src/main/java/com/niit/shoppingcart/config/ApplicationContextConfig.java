package com.niit.shoppingcart.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.OrderDAO;
import com.niit.shoppingcart.dao.PaymentDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.dao.impl.CartDAOImpl;
import com.niit.shoppingcart.dao.impl.CategoryDAOImpl;
import com.niit.shoppingcart.dao.impl.OrderDAOImpl;
import com.niit.shoppingcart.dao.impl.PaymentDAOImpl;
import com.niit.shoppingcart.dao.impl.ProductDAOImpl;
import com.niit.shoppingcart.dao.impl.SupplierDAOImpl;
import com.niit.shoppingcart.dao.impl.UserDAOImpl;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Order;
import com.niit.shoppingcart.model.Payment;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

@Configuration
@ComponentScan("com.niit")

@EnableTransactionManagement
public class ApplicationContextConfig {

	@Autowired
	@Bean(name="dataSource")	
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
	return (DataSource) dataSource;
	}
	
private Properties getHibernateProperties (){
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}
	

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());

		sessionBuilder.addAnnotatedClasses(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(Order.class);
		sessionBuilder.addAnnotatedClass(Payment.class);
		
		return sessionBuilder.buildSessionFactory();

	}

	@Autowired
	@Bean(name = "transactionmanager")
	public HibernateTransactionManager getTransactionalManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Autowired
	@Bean(name = "categoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) {
		return new CategoryDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory){
		return new UserDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "productDAO")
	public ProductDAO getProductDao(SessionFactory sessionFactory) {
		return new ProductDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name ="supplierDAO")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory){
		return new SupplierDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "orderDAO")
	public OrderDAO getOrderDAO(SessionFactory sessionFactory){
		return new OrderDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "cartDAO")
	public CartDAO getCartDAO(SessionFactory sessionFactory){
		return new CartDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "paymentDAO")
	public PaymentDAO getPaymentDAO(SessionFactory sessionFactory){
		return new PaymentDAOImpl(sessionFactory);
	}
}
