package org.example.interfaces;

import org.example.entities.User;

import java.util.List;

public interface IUserService {
  void createUser(User user);

  void deleteUser(int id);

  void updateUser(User user);

  User getUser(int id);

  List<User> listUsers();

}
