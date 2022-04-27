package fr.fms.entities;

public class Categories {
private int id;
private String genre;

public Categories(int id, String genre) {
	super();
	this.id = id;
	this.genre = genre;
}

@Override
public String toString() {
	return centerString(String.valueOf(id)) + centerString(genre);
}

public static String centerString(String str) {
	if(str.length() >= 20) return str;
	String dest = "                                        ";
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

public String getName() {
	return genre;
}

public void setName(String genre) {
	this.genre = genre;
}

}
