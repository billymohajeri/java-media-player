package org.example.repositories;

import org.example.databases.Database;
import org.example.entities.Playlist;

import java.util.List;
import java.util.Optional;

public class PlaylistRepository {
  private final List<Playlist> playlists;

  public PlaylistRepository(Database database) {
    this.playlists = database.playlists;
  }

  public void addPlaylist(Playlist playlist) {

  }

  public void removePlaylist(Playlist playlist) {

  }

  public void updatePlaylist(Playlist playlist) {

  }

  public Optional<Playlist> getPlaylistById(int id) {
    return playlists.stream()
            .filter(playlist -> playlist.getId() == id).findFirst();
  }

  public List<Playlist> getAllPlaylists() {
    return playlists;
  }
}