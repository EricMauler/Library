package fr.fms.app;
import fr.fms.dao.BooksDao;
import fr.fms.entities.Books;



public class LibraryApp {
	
	public static void main(String[] args) {
		testReadBooks();
	}
	
private static void testReadBooks() {
	BooksDao booksdao = new BooksDao();
		
	for(Books books : booksdao.readAll()) {
		System.out.println(books);
	}}}
	