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

  public void addPlaylist(Playlist playlist) {
    playlists.add(playlist);
  }

  public void removePlaylist(Playlist playlist) {
    playlists.remove(playlist);
  }

  public List<Playlist> getPlaylists() {
    return playlists;
  }
}
