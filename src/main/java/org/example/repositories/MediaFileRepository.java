package org.example.repositories;

import org.example.databases.Database;
import org.example.entities.MediaFile;

import java.util.List;
import java.util.Optional;

public class MediaFileRepository {
  private final List<MediaFile> mediaFiles;

  public MediaFileRepository(Database database) {
    this.mediaFiles = database.mediaFiles;
  }

  public void addMediaFile(MediaFile mediaFile) {
    mediaFiles.add(mediaFile);
  }

  public void removeMediaFile(MediaFile mediaFile) {
    mediaFiles.remove(mediaFile);
  }

  public void updateMediaFile(MediaFile mediaFile) {

  }

  public Optional<MediaFile> getMediaFileById(int id) {
    return mediaFiles.stream()
            .filter(mediaFile -> mediaFile.getId() == id).findFirst();
  }

  public List<MediaFile> getAllMediaFiles() {
    return mediaFiles;
  }
}
