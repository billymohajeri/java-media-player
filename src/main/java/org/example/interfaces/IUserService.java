package org.example.interfaces;

import org.example.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
  void createUser(User user);

  void deleteUser(User user);

  void updateUser(User user);

  Optional<User> getUser(int id);

  List<User> listUsers();

}
