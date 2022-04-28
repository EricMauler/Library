package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

import fr.fms.entities.Books;

public class BooksDao implements Dao<Books> {

	@Override
	public boolean create(Books obj) {
		try (Statement statement = connection.createStatement()){
			String str = "INSERT INTO T_Books (Title, Author, Edition, UnitaryPrice)"
						+ " VALUES ('"+ obj.getTitle()+"', ' "+ obj.getAuthor()+"' ,'"+ obj.getEdition()+"' , "+ obj.getPrice() +" );";			
			int row = statement.executeUpdate(str);
			if(row == 1)		return true;
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.log(Level.SEVERE,"pb sql sur la création d'un article");
		} 		
		return false;
	}
	
	//exemple d'insertion avec preparedStatement -> évite les attaques par injection sql
	public void createPrepared(Books obj) {
		String str = "INSERT INTO T_Books (Title, Author, Edition, UnitaryPrice) VALUES (?,?,?,?);";		//ToDo IdCategory
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getTitle());
			ps.setString(2, obj.getAuthor());
			ps.setString(3, obj.getEdition());	
			ps.setDouble(4, obj.getPrice());	
			
			if( ps.executeUpdate() == 1)	System.out.println("insertion ok");
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
	}

	@Override
	public Books read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Books where IdBook=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) return new Books(rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getString(4), rs.getDouble(5));
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return null;
	}

	@Override
	public boolean update(Books obj) {
		try (Statement statement = connection.createStatement()){
			String str = "UPDATE T_Books set Title='" + obj.getTitle() +"' , " +
							                   "Author='" 		+ obj.getAuthor() +"' , " +
					                           "Edition= '" + obj.getEdition() +"' , " +
							                   "UnitaryPrice=" + obj.getPrice() + " where IdBook=" + obj.getId() + ";";			
			statement.executeUpdate(str);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return false;
	}

	@Override
	public boolean delete(Books obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM T_Books where IdBooks=" + obj.getId() + ";";									
			statement.executeUpdate(str);		
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return false;
	}

	@Override
	public ArrayList<Books> readAll() {
		ArrayList<Books> books = new ArrayList<Books>();
		String strSql = "SELECT * FROM T_Books join t_categories on t_books.IdCategory = t_categories.IdCategory;";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);	
					String rsTitle = resultSet.getString(2);
					String rsAuthor = resultSet.getString(3);
					String rsEdition = resultSet.getString(4);
					double rsPrice = resultSet.getDouble(5);	
					
					books.add((new Books(rsId,rsTitle,rsAuthor, rsEdition, rsPrice)));						
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return books;
	}
	
	public ArrayList<Books> readAllByCat(int id) {
		ArrayList<Books> books = new ArrayList<Books>();
		String strSql = "SELECT * FROM T_Books where IdBook=" + id;		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);	
					String rsTitle = resultSet.getString(2);
					String rsAuthor = resultSet.getString(3);
					String rsEdition = resultSet.getString(4);
					double rsPrice = resultSet.getDouble(5);		
					books.add((new Books(rsId,rsTitle,rsAuthor,rsEdition,rsPrice)));						
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return books;
	}
}