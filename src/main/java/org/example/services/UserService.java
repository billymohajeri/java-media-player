package org.example.services;

import org.example.entities.User;
import org.example.interfaces.IUserService;
import org.example.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService implements IUserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void createUser(User user) {
  }

  public void deleteUser(int id) {

  }

  public void updateUser(User user) {
  }

  public Optional<User> getUser(int id) {
    return userRepository.getUserById(id);
  }

  public List<User> listUsers() {
    return userRepository.getAllUsers();
  }
}
