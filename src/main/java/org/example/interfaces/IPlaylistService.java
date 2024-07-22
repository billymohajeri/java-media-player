package org.example.interfaces;

import org.example.entities.Playlist;

import java.util.List;

public interface IPlaylistService {

  void createPlaylist(Playlist playlist);

  void deletePlaylist(int id);

  void updatePlaylist(Playlist playlist);

  Playlist getPlaylist(int id);

  List<Playlist> listPlaylists();

  void playMediaFromPlaylist(int playlistId, int mediaFileId);

  void pauseMediaInPlaylist(int playlistId, int mediaFileId);

  void stopMediaInPlaylist(int playlistId, int mediaFileId);
}
