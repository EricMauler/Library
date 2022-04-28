package fr.fms.dao;

import fr.fms.entities.Books;
import fr.fms.entities.Categories;
import fr.fms.entities.Customer;


public class DaoFactory {
	
	public static Dao<Books> getArticleDao() {
		return new BooksDao();		
	}
	
	public static Dao<Customer> getUserDao() {
		return new CustomerDao();
	}

	public static Dao<Customer> getCustomerDao() {
		return new CustomerDao();
	}

	public static Dao<Books> getBookDao() {
		return new BooksDao();
	}

	public static Dao<Categories> getCategoriesDao() {
		return new CategoriesDao();
	}
	
}
