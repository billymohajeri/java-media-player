package org.example.entities;

public class AudioFile extends MediaFile {
  int volume;
  String soundEffect;

  public AudioFile(int id, String name, String type, int volume, String soundEffect) {
    super(id, name, type);
    this.volume = volume;
    this.soundEffect = soundEffect;
  }

  public void adjustVolume(int volume) {
    this.volume = volume;
  }

  public void changeSoundEffect(String effect) {
    this.soundEffect = soundEffect;
  }

}
