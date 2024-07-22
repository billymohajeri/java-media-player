package org.example.entities;

import java.util.List;

public class Playlist {
  int id;
  String name;
  List<MediaFile> mediaFiles;

  public Playlist(int id, String name, List<MediaFile> mediaFiles) {
    this.id = id;
    this.name = name;
    this.mediaFiles = mediaFiles;
  }

  public void addMediaFile(MediaFile mediaFile) {

  }

  public void removeMediaFile(MediaFile mediaFile) {

  }

  public void getMediaFiles() {

  }

  public void playMedia(int mediaFileId) {

  }

  public void pauseMedia(int mediaFileId) {

  }

  public void stopMedia(int mediaFileId) {

  }
}
