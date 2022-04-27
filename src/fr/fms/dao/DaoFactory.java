package fr.fms.dao;

import fr.fms.entities.Books;
import fr.fms.entities.Customer;


public class DaoFactory {
	
	public static Dao<Books> getArticleDao() {
		return new BooksDao();		
	}
	
	public static Dao<Customer> getUserDao() {
		return new CustomerDao();
	}
	
}
