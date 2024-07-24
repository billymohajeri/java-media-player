package org.example.databases;

import org.example.entities.MediaFile;
import org.example.entities.Playlist;
import org.example.entities.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
  public List<MediaFile> mediaFiles;
  public List<User> users;
  public List<Playlist> playlists;

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
            new User(1, "Billy", "123456"),
            new User(2, "Walter", "123456"),
            new User(3, "Sky", "123456"),
            new User(4, "Jesse", "654321"),
            new User(5, "Hank", "abcdef"),
            new User(6, "Marie", "ghijkl"),
            new User(7, "Saul", "mnopqr"),
            new User(8, "Gus", "stuvwx"),
            new User(9, "Mike", "yzabcd"),
            new User(10, "Lydia", "efghij")
    ));
    this.playlists = new ArrayList<>(List.of(
            new Playlist(1, "Morning Vibes"),
            new Playlist(2, "Evening Relaxation"),
            new Playlist(3, "Workout Mix"),
            new Playlist(4, "Road Trip"),
            new Playlist(5, "Party Time"),
            new Playlist(6, "Chill Out"),
            new Playlist(7, "Classic Hits"),
            new Playlist(8, "Rock Legends"),
            new Playlist(9, "Top 40"),
            new Playlist(10, "Golden Oldies"),
            new Playlist(11, "Summer Hits"),
            new Playlist(12, "Winter Warmers"),
            new Playlist(13, "Autumn Acoustic"),
            new Playlist(14, "Spring Sing-Along"),
            new Playlist(15, "Instrumental"),
            new Playlist(16, "Pop Classics"),
            new Playlist(17, "Hip Hop Hits"),
            new Playlist(18, "Indie Favourites"),
            new Playlist(19, "Jazz Collection"),
            new Playlist(20, "Electronic Beats"))
    );
  }
}

