package entity;

public class Queens {
  private int queenId;
  private String firstName;
  private String lastName;
  
  public Queens(int queenId, String firstName, String lastName) {
    this.setQueenId(queenId);
    this.setFirstName(firstName);
    this.setLastName(lastName);
  }

  public int getQueenId() {
    return queenId;
  }

  public void setQueenId(int queenId) {
    this.queenId = queenId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
}
