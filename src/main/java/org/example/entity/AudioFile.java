package org.example.entity;

public class AudioFile extends MediaFile {
  int volume;
  String soundEffect;

  public AudioFile(int id, String name, String type, int volume, String soundEffect) {
    super(id, name, type);
    this.volume = volume;
    this.soundEffect = soundEffect;
  }

  public void adjustVolume(int volume) {

  }

  public void changeSoundEffect(String effect) {

  }

}
