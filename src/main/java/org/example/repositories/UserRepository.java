package org.example.repositories;

import org.example.databases.Database;
import org.example.entities.User;

import java.util.List;
import java.util.Optional;

public class UserRepository {
  private final List<User> users;

  public UserRepository(Database database) {
    this.users = database.users;
  }

  public void addUser(User user) {
    users.add(user);
  }

  public void removeUser(User user) {

  }

  public void updateUser(User user) {

  }

  public Optional<User> getUserById(int id) {
    return users.stream()
            .filter(user -> user.getId() == id).findFirst();
  }

  public List<User> getAllUsers() {
    return users;
  }
}
