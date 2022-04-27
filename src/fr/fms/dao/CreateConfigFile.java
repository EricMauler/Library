package fr.fms.dao;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;



public class CreateConfigFile {
	public static void main(String[] args) {
		try (OutputStream ops = new FileOutputStream("config.properties")) {		
			Properties properties = new Properties();	
			properties.setProperty("db.driver", "org.mariadb.jdbc.Driver");
			properties.setProperty("db.url", "jdbc:mariadb://localhost:3306/Shop");
			properties.setProperty("db.login", "root");
			properties.setProperty("db.password", "fms2022");			
			properties.store(ops , "No comment !");
		}
		 catch (IOException io) {
	            io.printStackTrace();
		}
	}

}
