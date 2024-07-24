package org.example.entities;

import lombok.Getter;

import java.util.List;

@Getter


public class User {
  private final int id;
  private String username;
  private String password;
  private List<Playlist> playlists;

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
