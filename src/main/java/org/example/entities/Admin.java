package org.example.entities;

public class Admin extends User {
  public Admin(int id, String username, String password) {
    super(id, username, password);
  }

  void addUser(User user) {

  }

  public boolean removeUser(User user) {
    return true;
  }

  public boolean updateUser(User user) {
    return true;
  }
}
