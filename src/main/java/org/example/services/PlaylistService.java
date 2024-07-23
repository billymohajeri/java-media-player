package org.example.services;

import org.example.entities.Playlist;
import org.example.interfaces.IPlaylistService;
import org.example.repositories.PlaylistRepository;

import java.util.List;
import java.util.Optional;

public class PlaylistService implements IPlaylistService {
  private final PlaylistRepository playlistRepository;

  public PlaylistService(PlaylistRepository playlistRepository) {
    this.playlistRepository = playlistRepository;
  }

  public void createPlaylist(Playlist playlist) {
  }

  public void deletePlaylist(int id) {
  }

  public void updatePlaylist(Playlist playlist) {
  }

  public Optional<Playlist> getPlaylist(int id) {
    return playlistRepository.getPlaylistById(id);
  }

  public List<Playlist> listPlaylists() {
    return playlistRepository.getAllPlaylists();
  }

  public void playMediaFromPlaylist(int playlistId, int mediaFileId) {
  }

  public void pauseMediaInPlaylist(int playlistId, int mediaFileId) {
  }

  public void stopMediaInPlaylist(int playlistId, int mediaFileId) {
  }
}
