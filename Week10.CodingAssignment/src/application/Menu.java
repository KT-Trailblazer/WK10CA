package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import dao.QueensDao;
import entity.Queens;

public class Menu {

  private Scanner scanner = new Scanner(System.in);
  private List<String> options = Arrays.asList (
      "Add Drag Queen",
      "Display Drag Queens",
      "Update Drag Queen",
      "Delete Drag Queen",
      "Exit"
      );
      
  public void start() {
    String selection = "";
    
    do {
      printMenu();
      selection = scanner.nextLine();
      
      try {
        if (selection.equals("1")) {
          createDragQueen();
        } else if (selection.equals("2") ) {
          displayDragQueens();
        } else if (selection.equals("3") ) {
          updateDragQueen();
        } else if (selection.equals("4") ) {
          deleteDragQueen();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
   
  } while (!selection.equals("5"));
  }
  
  private void printMenu() {
    System.out.println("Select an option: \n--------------");
    for (int i=0; i < options.size(); i++) {
      System.out.println(i + 1 + ")" + options.get(i) );;
    }
  }
  
  private void createDragQueen() throws SQLException {
    System.out.print("Add First Name: ");
    String firstName = scanner.nextLine();
    System.out.print("Add Last Name: ");
    String lastName = scanner.nextLine();
    QueensDao queensDao = new QueensDao();
    queensDao.createNewQueen(firstName, lastName);
  }
  
  private void displayDragQueens() throws SQLException {
    List<Queens> queens = QueensDao.getAll();
    for (Queens queen : queens) {
      System.out.println(queen.getQueenId() + ": " + queen.getFirstName() + " " + queen.getLastName());
    }
  }
    
  private void updateDragQueen() throws SQLException {
    System.out.print("Add First Name: ");
    String firstName = scanner.nextLine();
    System.out.print("Add Last Name: ");
    String lastName = scanner.nextLine();
    System.out.print("Enter Drag Queen ID to Update:");
    int id = Integer.parseInt(scanner.nextLine());
    QueensDao queensDao = new QueensDao();
    queensDao.updateQueenByID(firstName, lastName, id);
  }
  
  private void deleteDragQueen() throws SQLException {
    System.out.print("Enter Queen ID to delete: ");
    int id = Integer.parseInt(scanner.nextLine());
    QueensDao queensDao = new QueensDao();
    queensDao.deleteQueenById(id);
  }
}
