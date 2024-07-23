package org.example.entities;

import java.util.List;

public class Admin extends User {


  public Admin(int id, String username, String password, List<Playlist> playlists) {
    super(id, username, password, playlists);
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
