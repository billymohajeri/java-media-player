package org.example;

import org.example.databases.Database;
import org.example.entities.MediaFile;
import org.example.entities.Playlist;
import org.example.entities.User;
import org.example.repositories.MediaFileRepository;
import org.example.repositories.PlaylistRepository;
import org.example.repositories.UserRepository;
import org.example.services.MediaFileService;
import org.example.services.PlaylistService;
import org.example.services.UserService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
  private static final String RED = "\033[0;31m";
  private static final String BLUE = "\033[0;34m";
  private static final String YELLOW = "\033[0;33m";

  private static final Database database = new Database();

  private static final MediaFileRepository mediaFileRepository = new MediaFileRepository(database);
  private static final MediaFileService mediaFileService = new MediaFileService(mediaFileRepository);
  private static final List<MediaFile> mediaFiles = mediaFileService.listMediaFiles();

  private static final UserRepository userRepository = new UserRepository(database);
  private static final UserService userService = new UserService(userRepository);
  private static final List<User> users = userService.listUsers();

  private static final PlaylistRepository playlistRepository = new PlaylistRepository(database);
  private static final PlaylistService playlistService = new PlaylistService(playlistRepository);
  private static final List<Playlist> playlists = playlistService.listPlaylists();

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String choice = "";
    while (!choice.equalsIgnoreCase("Q")) {
      System.out.println(BLUE + "\n1- Show all media files");
      System.out.println("2- Show media file by ID");
      System.out.println("3- Show all users");
      System.out.println("4- Show user by ID");
      System.out.println("5- Add user");
      System.out.println("6- Delete user");
      System.out.println("7- Show all playlists");
      System.out.println("8- Show playlist by ID");
      System.out.println("Q- Quit");
      System.out.println(BLUE + "Enter your choice: ");
      choice = scanner.nextLine().toUpperCase();

      switch (choice) {
        case "1" -> printAllMediaFiles();
        case "2" -> printMediaFileById();
        case "3" -> printAllUsers();
        case "4" -> printUserById();
        case "5" -> addUser();
        case "6" -> delUser();
        case "7" -> printAllPlaylists();
        case "8" -> printPlaylistById();
        case "Q" -> System.out.println(RED + "Exiting the app...");
        default -> System.out.println(RED + "Invalid choice, try again!");
      }
    }
  }

  private static void printAllMediaFiles() {
    System.out.println(YELLOW + "\nHere is the list of all media files:");
    for (MediaFile mediaFile : mediaFiles) {
      System.out.println(mediaFile.getId() + ": " + mediaFile.getName() + " - " + mediaFile.getType());
    }
  }

  private static void printMediaFileById() {
    {
      System.out.print("Enter the media file ID: ");
      String id = scanner.nextLine();
      try {
        Optional<MediaFile> optionalMediaFile = mediaFileService.getMediaFile(Integer.parseInt(id));
        if (optionalMediaFile.isPresent()) {
          MediaFile mediaFile = optionalMediaFile.get();
          System.out.println(YELLOW + "\n" + id + ": " + mediaFile.getName() + " - " + mediaFile.getType());
        } else {
          System.out.println(RED + "Media file with ID " + id + " not found.");
        }
      } catch (NumberFormatException e) {
        System.out.println(RED + "Invalid ID format: " + id);
      } catch (Exception e) {
        System.out.println(RED + "Error: " + e.getMessage());
      }
    }
  }

  private static void printAllUsers() {
    System.out.println(YELLOW + "\nHere is the list of all users:");
    for (org.example.entities.User user : users) {
      System.out.println(user.getId() + ": " + user.getUsername());
    }
  }

  private static void printUserById() {
    System.out.print("Enter the user ID: ");
    String id = scanner.nextLine();
    try {
      Optional<User> optionalUser = userService.getUser(Integer.parseInt(id));
      if (optionalUser.isPresent()) {
        User user = optionalUser.get();
        System.out.println(YELLOW + "\n" + id + ": " + user.getUsername());
      } else {
        System.out.println(RED + "User with ID " + id + " not found.");
      }
    } catch (NumberFormatException e) {
      System.out.println(RED + "Invalid ID format: " + id);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private static void addUser() {
    System.out.print("\nUser ID: ");
    int id = Integer.parseInt(scanner.nextLine());
    System.out.print("Username: ");
    String username = scanner.nextLine();
    System.out.print("Password: ");
    String password = scanner.nextLine();
    User newUser = new User(id, username, password);
    try {
      userService.createUser(newUser);
      System.out.println("\nUser created successfully!");
    } catch (Exception e) {
      System.out.println(RED + "Error: " + e.getMessage());
    }
    printAllUsers();
  }

  private static void delUser() {
    System.out.print("\nUser ID: ");
    int id = Integer.parseInt(scanner.nextLine());
    try {
      Optional<User> optionalUser = userService.getUser(id);
      if (optionalUser.isPresent()) {
        User user = optionalUser.get();
        System.out.println("\nUser " + id + ": " + user.getUsername() + " deleted successfully!");
        userService.deleteUser(user);
        printAllUsers();
      } else {
        System.out.println(RED + "User with ID " + id + " not found.");
      }
    } catch (NumberFormatException e) {
      System.out.println(RED + "Invalid ID format: " + id);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private static void printAllPlaylists() {
    System.out.println(YELLOW + "\nHere is the list of all playlists:");
    for (org.example.entities.Playlist playlist : playlists) {
      System.out.println(playlist.getId() + ": " + playlist.getName());
    }
  }

  private static void printPlaylistById() {
    System.out.print("Enter the playlist ID: ");
    String id = scanner.nextLine();
    try {
      Optional<Playlist> optionalPlaylist = playlistService.getPlaylist(Integer.parseInt(id));
      if (optionalPlaylist.isPresent()) {
        Playlist playlist = optionalPlaylist.get();
        System.out.println(YELLOW + "\n" + id + ": " + playlist.getName());
      } else {
        System.out.println(RED + "Playlist with ID " + id + " not found.");
      }
    } catch (NumberFormatException e) {
      System.out.println(RED + "Invalid ID format: " + id);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}