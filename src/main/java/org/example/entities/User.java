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
