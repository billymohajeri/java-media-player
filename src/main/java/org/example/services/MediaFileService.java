package org.example.services;

import org.example.entities.MediaFile;
import org.example.interfaces.IMediaFileService;
import org.example.repositories.MediaFileRepository;

import java.util.List;
import java.util.Optional;

public class MediaFileService implements IMediaFileService {
  private final MediaFileRepository mediaFileRepository;

  public MediaFileService(MediaFileRepository mediaFileRepository) {
    this.mediaFileRepository = mediaFileRepository;
  }

  public void addMediaFile(MediaFile mediaFile) {
  }

  public void deleteMediaFile(int id) {
  }

  public void updateMediaFile(MediaFile mediaFile) {
  }

  public Optional<MediaFile> getMediaFile(int id) {
    return mediaFileRepository.getMediaFileById(id);
  }

  public List<MediaFile> listMediaFiles() {
    return mediaFileRepository.getAllMediaFiles();
  }

  public void playMedia(int id) {
  }

  public void pauseMedia(int id) {
  }

  public void stopMedia(int id) {
  }

  public void adjustVolume(int id, int volume) {
  }

  public void adjustBrightness(int id, int brightness) {
  }

  public void changeSoundEffect(int id, String effect) {
  }
}
