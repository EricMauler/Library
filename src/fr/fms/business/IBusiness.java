package fr.fms.business;

import java.util.ArrayList;
import fr.fms.entities.Books;
import fr.fms.entities.Categories;

public interface IBusiness {	
	/**
	 * m�thode qui ajoute un article au panier
	 * @param article � ajouter
	 */
	public void addToCart(Books book);		
	
	/**
	 * m�thode qui retire un article au panier s'il est dedans
	 * @param id de l'article � retirer
	 */
	public void rmFromCart(int id);		
	
	/**
	 * m�thode qui renvoi sous la forme d'une liste tous les �l�ments du panier (gestion en m�moire)
	 * @return Liste d'articles du panier
	 */
	public ArrayList<Books> getCart();	
	
	/**
	 * m�thode qui r�alise la commande en base avec l'idUser + total de la commande en cours + date du jour + contenu du panier :
	 * - la m�thode va c�er une commande en base -> idOrder + montant + date + idUser
	 * - puis va ajouter autant de commande minifi�e associ�e : orderItem -> idOrderItem + idArticle + Quantity + Price + idOrder
	 * @param idUser est l'identifiant du client qui est pass� commande
	 * @return 1 si tout est ok 0 si pb 
	 */
	public int order(int idUser);		
	
	/**
	 * m�thode qui renvoi tous les articles de la table t_articles en bdd
	 * @return Liste d'articles en base
	 */
	public ArrayList<Books> readArticles();	
	
	/**
	 * m�thode renvoie l'article correspondant � l'id
	 * @param id de l'article � renvoyer
	 * @return article correspondant si trouv�, null sinon
	 */
	public Books readOneArticle(int id);	
	
	/**
	 * m�thode qui renvoi toutes les cat�gories de la table t_cat�gories en bdd
	 * @return Liste de cat�gories en base
	 */
	public ArrayList<Categories> readCategories();
	
	/**
	 * m�thode qui renvoi tous les articles d'une cat�gorie
	 * @param id de la cat�gorie
	 * @return Liste d'articles
	 */
	public ArrayList<Books> readArticlesByCatId(int idCat);

	ArrayList<Books> readbooks();

	Books readOneBook(int id);
}
