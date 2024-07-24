package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor

public class User {
  private final int id;
  private String username;
  private String password;
  private List<Playlist> playlists;

  void addPlaylist(Playlist playlist) {

  }

  public boolean removePlaylist(Playlist playlist) {
    return true;
  }

  public void getPlaylists() {

  }
}
