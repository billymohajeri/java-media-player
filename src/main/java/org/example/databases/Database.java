package org.example.databases;

import org.example.entities.MediaFile;

import java.util.ArrayList;
import java.util.List;

public class Database {
  public List<MediaFile> mediaFiles;

  public Database() {
    this.mediaFiles = new ArrayList<>(List.of(
            new MediaFile(1, "Jenny", "Audio"),
            new MediaFile(2, "In the Shadows", "Audio"),
            new MediaFile(3, "Cha Cha Cha", "Audio")
    ));
  }
}
