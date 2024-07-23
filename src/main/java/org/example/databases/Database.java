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
            new MediaFile(3, "Cha Cha Cha", "Audio"),
            new MediaFile(4, "Satumaa", "Audio"),
            new MediaFile(5, "Paratiisi", "Audio"),
            new MediaFile(6, "Leijat", "Audio"),
            new MediaFile(7, "Tule hiljaa", "Audio"),
            new MediaFile(8, "Aamu", "Audio"),
            new MediaFile(9, "Kultainen nuoruus", "Audio"),
            new MediaFile(10, "Rakastan elämää", "Audio"),
            new MediaFile(11, "Tuntematon sotilas", "Video"),
            new MediaFile(12, "Talvisota", "Video"),
            new MediaFile(13, "Rautatie", "Video"),
            new MediaFile(14, "Mies vailla menneisyyttä", "Video"),
            new MediaFile(15, "Napapiirin sankarit", "Video")
    ));
    this.users = new ArrayList<>(List.of(
            new User(1, "Billy", "123456", new ArrayList<>()),
            new User(2, "Walter", "123456", new ArrayList<>()),
            new User(3, "Sky", "123456", new ArrayList<>()),
            new User(4, "Jesse", "654321", new ArrayList<>()),
            new User(5, "Hank", "abcdef", new ArrayList<>()),
            new User(6, "Marie", "ghijkl", new ArrayList<>()),
            new User(7, "Saul", "mnopqr", new ArrayList<>()),
            new User(8, "Gus", "stuvwx", new ArrayList<>()),
            new User(9, "Mike", "yzabcd", new ArrayList<>()),
            new User(10, "Lydia", "efghij", new ArrayList<>())
    ));


  }
}

