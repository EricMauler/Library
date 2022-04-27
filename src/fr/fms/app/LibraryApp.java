package fr.fms.app;
import java.util.Scanner;

import fr.fms.business.IBusinessImpl;
import fr.fms.dao.BooksDao;
import fr.fms.entities.Books;
import fr.fms.entities.Categories;

public class LibraryApp {
	private static IBusinessImpl business = new IBusinessImpl();
	private static Scanner scan = new Scanner(System.in); 
	private static int idUser = 0;
	private static String login = null; 


	public static void main(String[] args) {
		System.out.println("Bonjour et bienvenu dans ma librairie en ligne, voici la liste des livres en stock\n");
		displayBooks();
		testReadBooks();
		int choice = 0;
		while(choice != 8) {
			displayMenu();
			choice = scanInt();
			switch(choice) {
				case 1 : addBook();				
					break;					
				case 2 : remBook();
					break;					
				case 3 : displayCart(true);
					break;					
				case 4 : displayBooks();
					break;						
				case 5 : displayCategories();
					break;
				case 6 : displayArticlesByCategoryId();
					break;
				case 7 : connection();
					break;
				case 8 : System.out.println("à bientôt dans notre boutique :)");
					break;					
				default : System.out.println("veuillez saisir une valeur entre 1 et 8");
			}
	}
	}
	
	private static void connection() {
		if(login != null)	System.out.println("vous êtes déjà connecté");
		else {
			System.out.println("saisissez votre login : ");
			String log = scan.next();
			System.out.println("saisissez votre password : ");
			String pwd = scan.next();
			
			int id = business.existUser(log,pwd);
			if(id > 0)	{
				login = log;
				idUser = id;
			}
			else System.out.println("login ou password incorrect");
		}
	}
	
	private static void displayArticlesByCategoryId() {
		System.out.println("saisissez l'id de la catégorie concerné");
		int id = scanInt();
		Categories category = business.readOneCategory(id);
		if(category != null) {
			System.out.println("Catégorie : " + category.getName());
			String titles = Books.centerString("IDENTIFIANT") + Books.centerString("TITLE") + Books.centerString("AUTEUR") + Books.centerString("EDITION") + Books.centerString("PRIX");
			System.out.println(titles);
			business.readArticlesByCatId(id).forEach(System.out::println);
		}
		else System.out.println("cette catégorie n'existe pas !");
	}
	
	private static void displayCategories() {
		String titles = Categories.centerString("IDENTIFIANT") + Categories.centerString("GENRE");
		System.out.println(titles);
		business.readCategories().forEach(System.out::println);		
	}
	
	
	private static void displayCart(boolean flag) {
		if(business.isCartEmpty()) 	System.out.println("PANIER VIDE");
		else {
			System.out.println("CONTENU DU PANIER :");
			String titles = Books.centerString("IDENTIFIANT") + Books.centerString("TITRE") + 
					Books.centerString("AUTEUR") + Books.centerString("EDITION") + Books.centerString("PRIX") + Books.centerString("QUANTITE");
			System.out.println(titles);
			business.getCart().forEach(a -> System.out.println(a.toString() + Books.centerString(String.valueOf(a.getQuantity()))));
			if(flag) {
				System.out.println("MONTANT TOTAL : " + business.getTotal());
				System.out.println("Souhaitez vous passer commande ? Oui/Non :");
				if(scan.next().equalsIgnoreCase("Oui")) {
					if(login == null)	{ 
						System.out.println("Vous devez être connecté pour continuer");
						connection();
					}
					if(login != null) {
						int idOrder = business.order(idUser);
						if(idOrder == 0)	System.out.println("pb lors du passage de commande");
						else {
							System.out.println("Votre commande a bien été validé, voici son numéro : " + idOrder);
							business.clearCart();
						}
					}
				}
			}
		}
	}
	
	public static void remBook() {
		System.out.println("Selectionner l'id de l'article à supprimer du panier");
		int id = scanInt();
		business.rmFromCart(id);
		displayCart(false);
	}
	
	public static void addBook() {
		System.out.println("Selectionner l'id du livre à ajouter au panier");
		int id = scanInt();
		Books book = business.readOneBook(id);
		if(book != null) {
			business.addToCart(book);
			displayCart(false);
		}
		else System.out.println("l'article que vous souhaitez ajouter n'existe pas, pb de saisi id");
	} 

		public static void displayMenu() {	
			if(login != null)	System.out.print("Compte : " + login);
			System.out.println("\n" + "Pour réaliser une action, tapez le code correspondant");
			System.out.println("1 : Ajouter un article au panier");
			System.out.println("2 : Retirer un article du panier");
			System.out.println("3 : Afficher le contenu de mon panier, le total et passer commande");
			System.out.println("4 : Afficher tous les articles en stock");
			System.out.println("5 : Afficher toutes les catégories en base");
			System.out.println("6 : Afficher tous les articles d'une catégorie");
			System.out.println("7 : Connexion à votre compte");
			System.out.println("8 : sortir de l'application");
		}
		
		public static int scanInt() {
			while(!scan.hasNextInt()) {
				System.out.println("saisissez une valeur entière svp");
				scan.next();
			}
			return scan.nextInt();
		}
	
 private static void testReadBooks() {
	BooksDao booksdao = new BooksDao();
	for(Books books : booksdao.readAll()) {	System.out.println(books);}}
//	Books books = booksdao.read(2);
//	System.out.println(books);
//	    books.setTitle("Lombilic des limbes");
//	    booksdao.update(books);
	
 //  	System.out.println(books);
	
	public static void displayBooks() { 		
		String titles = Books.centerString("IDENTIFIANT") + Books.centerString("TITRE") + Books.centerString("AUTEUR") + Books.centerString("EDITION") +  Books.centerString("PRIX") ;
		System.out.println(titles);}
//		business.readbooks().forEach(System.out::println);}
	
}
	
	
