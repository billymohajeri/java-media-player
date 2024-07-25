package org.example.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class User {
  private final int id;
  private String username;
  private String password;
  private boolean isAdmin;
  private List<Playlist> playlists;

  public User(int id, String username, String password, boolean isAdmin) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.isAdmin = isAdmin;
  }

  public void addPlaylist(Playlist playlist) {
    if (playlists == null) {
      playlists = new ArrayList<>();
    }
    playlists.add(playlist);
  }

  public void removePlaylist(Playlist playlist) {
    playlists.remove(playlist);
  }

  public List<Playlist> getPlaylists() {
    return (playlists != null) ? playlists : new ArrayList<>();
  }
}
