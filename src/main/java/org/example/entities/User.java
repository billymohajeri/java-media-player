package org.example.entities;

import java.util.List;

public class User {
  int id;
  String username;
  String password;
  List<Playlist> playlists;

  public User(int id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }


  void addPlaylist(Playlist playlist) {

  }

  public boolean removePlaylist(Playlist playlist) {
    return true;
  }

  public void getPlaylists() {

  }
}
