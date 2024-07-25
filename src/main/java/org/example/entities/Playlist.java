package org.example.entities;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    if (mediaFiles == null) {
      mediaFiles = new ArrayList<>();
    }
    mediaFiles.add(mediaFile);
  }

  public void removeMediaFile(MediaFile mediaFile) {
    mediaFiles.remove(mediaFile);
  }

  public List<MediaFile> getMediaFiles() {
    return (mediaFiles != null) ? mediaFiles : new ArrayList<>();
  }

  public void playMedia(int mediaFileId) {
    if (mediaFiles == null) {
      mediaFiles = new ArrayList<>();
      System.out.println("\nThere is no media file in this playlist");
    } else {
      Optional<MediaFile> optionalMediaFile = mediaFiles.stream()
              .filter(mediaFile -> mediaFile.getId() == mediaFileId).findFirst();
      if (optionalMediaFile.isPresent()) {
        MediaFile mediaFile = optionalMediaFile.get();
        System.out.println("Playing media file: " + mediaFile.getName() + "...");
      }
    }
  }

  public void pauseMedia(int mediaFileId) {

  }

  public void stopMedia(int mediaFileId) {

  }
}
