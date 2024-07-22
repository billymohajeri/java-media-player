package org.example.entities;

public class MediaFile {
  private int id;
  private String name;
  private String type;

  public MediaFile(int id, String name, String type) {
    this.id = id;
    this.name = name;
    this.type = type;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
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
