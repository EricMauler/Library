package fr.fms.entities;

public class Books {

	private int id;
	private String title;
	private String author;
	private String edition;
	private double price;
	private int category;
	
	public Books(int id, String title, String author, String edition, double price, int category) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.edition = edition;
		this.price = price;
		this.category = category;
	}

	public Books(int id, String title, String author, String edition, double price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.edition = edition;
		this.price = price;
	}

	public Books(String title, String author, String edition, double price) {
		super();
		this.title = title;
		this.author = author;
		this.edition = edition;
		this.price = price;
	}

	public String toString() {
		return centerString(String.valueOf(id)) + centerString(title) + centerString(author) + centerString(edition)  + centerString(String.valueOf(price));
	}
	
	public static String centerString(String str) {
		if(str.length() >= 20) return str;
		String dest = "                    ";
		int deb = (20 - str.length())/2 ;
		String data = new StringBuilder(dest).replace( deb, deb + str.length(), str ).toString();
		return data;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
	
	
}
