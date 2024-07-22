package org.example.entities;

public class VideoFile extends MediaFile {
  int volume;
  int brightness;

  public VideoFile(int id, String name, String type, int volume, int brightness) {
    super(id, name, type);
    this.volume = volume;
    this.brightness = brightness;
  }

  public void adjustVolume(int volume) {
    this.volume = volume;
  }

  public void adjustBrightness(int brightness) {
    this.brightness = brightness;
  }
}
