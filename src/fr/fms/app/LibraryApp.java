package fr.fms.app;

import fr.fms.dao.BooksDao;
import fr.fms.entities.Books;

public class LibraryApp {
	public static void main(String[] args) {
		BooksDao booksDao = new BooksDao();
		testReadBooks();
	}

	
 private static void testReadBooks() {
	BooksDao booksdao = new BooksDao();
	for(Books books : booksdao.readAll()) {	System.out.println(books);}
//	Books books = booksdao.read(2);
//	System.out.println(books);
//	    books.setTitle("Lombilic des limbes");
//	    booksdao.update(books);
 //  	System.out.println(books);
}}