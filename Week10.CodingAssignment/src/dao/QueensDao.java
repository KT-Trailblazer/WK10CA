package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Queens;

public class QueensDao {
  private static Connection connection;
  private final String CREATE_NEW_QUEEN = "INSERT INTO queens(first_name, last_name) VALUES(?,?)";
  private final static String GET_QUEENS_QUERY = "SELECT * FROM queens";
  private final String UPDATE_QUEEN_BY_ID = "UPDATE queens SET first_name=?, last_name=? WHERE id=?";
  private final String DELETE_QUEEN_BY_ID = "DELETE FROM queens WHERE id = ?";
  
  public QueensDao() {
    connection = DBConnection.getConnection();
  }
  
  public void createNewQueen(String firstName, String lastName) throws SQLException {
    PreparedStatement ps = connection.prepareStatement(CREATE_NEW_QUEEN);
    ps.setString(1, firstName);
    ps.setString(2, lastName);
    ps.executeUpdate();
  }
  
   public static List<Queens> getAll() throws SQLException {
     ResultSet rs = connection.prepareStatement(GET_QUEENS_QUERY).executeQuery();
     List<Queens> all = new ArrayList<Queens>();
     
     while(rs.next()) {
       all.add(new Queens(rs.getInt(1), rs.getString(2), rs.getString (3)));
     }
     return all;
   }
   
     
  public void updateQueenByID(String firstName, String lastName, int id) throws SQLException {
    PreparedStatement ps = connection.prepareStatement(UPDATE_QUEEN_BY_ID);
    ps.setString(1, firstName);
    ps.setString(2, lastName);
    ps.setInt(3, id);
    ps.executeUpdate();
  }
  
  public void deleteQueenById(int id) throws SQLException {
    PreparedStatement ps = connection.prepareStatement(DELETE_QUEEN_BY_ID);
    ps.setInt(1, id);
    ps.executeUpdate(); 
  }

    
  }
  
  
  
  
  

