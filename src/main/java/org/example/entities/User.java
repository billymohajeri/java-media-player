package org.example.entities;

import java.util.List;

public class User {
  private final int id;
  private String username;
  private String password;
  private List<Playlist> playlists;

  public User(int id, String username, String password, List<Playlist> playlists) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.playlists = playlists;
  }

  public int getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  void addPlaylist(Playlist playlist) {

  }

  public boolean removePlaylist(Playlist playlist) {
    return true;
  }

  public void getPlaylists() {

  }
}
