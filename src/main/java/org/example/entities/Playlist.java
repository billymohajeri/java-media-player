package org.example.entities;

import lombok.Getter;

import java.util.List;

@Getter

public class Playlist {
  private final int id;
  private String name;
  private List<MediaFile> mediaFiles;

  public Playlist(int id, String name) {
    this.id = id;
    this.name = name;
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
