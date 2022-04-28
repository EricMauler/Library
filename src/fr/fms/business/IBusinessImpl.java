package fr.fms.business;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import fr.fms.dao.BooksDao;
import fr.fms.dao.CategoriesDao;
import fr.fms.dao.CustomerDao;
import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.dao.OrderDao;
import fr.fms.dao.OrderItemDao;
import fr.fms.entities.Article;
import fr.fms.entities.Books;
import fr.fms.entities.Categories;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.OrderItem;

public class IBusinessImpl implements IBusiness {
	private HashMap<Integer,Books> cart;
	private Dao<Books> BooksDao = DaoFactory.getBookDao();
	private Dao<Customer> CustomerDao = DaoFactory.getCustomerDao();
	private Dao<Categories> CategoriesDao = DaoFactory.getCategoriesDao();
	
	
	public IBusinessImpl() {
		this.cart = new HashMap<Integer,Books>();
	}

	public int existUser(String log, String pwd) {
		for(Customer customer : CustomerDao.readAll())
			if(customer.getLogin().equalsIgnoreCase(log) && customer.getPwd().equals(pwd))
				return customer.getId();
		return 0;
	}
	
	public void clearCart() {
		cart.clear();		
	}
	
	public double getTotal() {
		double [] total = {0};
		cart.values().forEach((a) -> total[0] += a.getPrice() * a.getQuantity()); 	
		return total[0];
	}
	
	public boolean isCartEmpty() {
		return cart.isEmpty();
	}

	@Override
	public void addToCart(Books book) {
		Books art = cart.get(book.getId());
		if(art != null) {
			art.setQuantity(art.getQuantity() + 1);
		}
		else cart.put(book.getId(), book);
	}

	@Override
	public void rmFromCart(int id) {
		Books book = cart.get(id);
		if(book != null) {
			if(book.getQuantity() == 1)	cart.remove(id);
			else book.setQuantity(book.getQuantity() -1);
		}				
	}


	@Override
	public ArrayList<Books> getCart() {
		return new ArrayList<Books> (cart.values());
	}

	@Override
	public int order(int IdCustomer) {
		if(CustomerDao.read(IdCustomer) != null) {
			double total = getTotal(); 
			Order order = new Order(total, new Date(), IdCustomer);
			if(OrderDao.create(order)) {	//ajout en base de la commande
				for(Books books : cart.values()) {	//ajout des commandes minifiées associées
					OrderItemDao.create(new OrderItem(0, books.getId(), books.getQuantity(), books.getPrice(), books.getIdOrder()));
				}
				return order.getIdOrder();
			}
		}
		return 0;
	}

	@Override
	public ArrayList<Books> readArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Categories> readCategories() {
		return CategoriesDao.readAll();
		}

	@Override
	public ArrayList<Books> readArticlesByCatId(int idCat) {
		return ((BooksDao) BooksDao).readAllByCat(idCat);
		}
	@Override
	public ArrayList<Books> readbooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Books readOneBook(int id) {
		return BooksDao.read(id);
	}

	public Categories readOneCategory(int id) {
		return CategoriesDao.read(id);
	}

	@Override
	public Books readOneArticle(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}