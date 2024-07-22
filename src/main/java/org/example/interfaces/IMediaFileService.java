package org.example.interfaces;

import org.example.entities.MediaFile;

import java.util.List;

public interface IMediaFileService {
  void addMediaFile(MediaFile mediaFile);

  void deleteMediaFile(int id);

  void updateMediaFile(MediaFile mediaFile);

  MediaFile getMediaFile(int id);

  List<MediaFile> listMediaFiles();

  void playMedia(int id);

  void pauseMedia(int id);

  void stopMedia(int id);

  void adjustVolume(int id, int volume);

  void adjustBrightness(int id, int brightness);

  void changeSoundEffect(int id, String effect);
}
