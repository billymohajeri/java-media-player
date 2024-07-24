package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class MediaFile {
  private final int id;
  private final String name;
  private String type;

  public void updateType(String type) {
    this.type = type;
  }

  public void play() {
    System.out.println("Playing media file: " + name);
  }

  public void pause() {
    System.out.println("Pausing media file: " + name);
  }

  public void stop() {
    System.out.println("Stopping media file: " + name);
  }

  public void adjustSetting(String setting, int value) {

  }
}
