package fr.fms.dao;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Categories;

public class CategoriesDao implements Dao<Categories>{

	@Override
	public boolean create(Categories obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Categories read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Categories where IdCategory=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) return new Categories(rs.getInt(1) , rs.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return null;
	}

	@Override
	public boolean update(Categories obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Categories obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Categories> readAll() {
		ArrayList<Categories> categories = new ArrayList<Categories>();
		String sql = "select * from T_Categories";
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(sql)){
				while(resultSet.next()) {
					categories.add(new Categories(resultSet.getInt("idCategory"), resultSet.getString(2)));
				}
				return categories;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

}
