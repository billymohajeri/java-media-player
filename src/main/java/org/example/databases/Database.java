package org.example.databases;

import org.example.entities.MediaFile;
import org.example.entities.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
  public List<MediaFile> mediaFiles;
  public List<User> users;

  public Database() {
    this.mediaFiles = new ArrayList<>(List.of(
            new MediaFile(1, "Jenny", "Audio"),
            new MediaFile(2, "In the Shadows", "Audio"),
            new MediaFile(3, "Cha Cha Cha", "Audio")
    ));
    this.users = new ArrayList<>(List.of(
            new User(1, "Billy", "123456", new ArrayList<>()),
            new User(2, "Walter", "123456", new ArrayList<>()),
            new User(3, "Sky", "123456", new ArrayList<>())
    ));


  }
}

