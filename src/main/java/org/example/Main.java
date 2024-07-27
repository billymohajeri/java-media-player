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
    login();
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

  private static void addNewMediaFile() {
    System.out.print("\nMedia file ID: ");
    int id = Integer.parseInt(scanner.nextLine());
    System.out.print("Media file name: ");
    String name = scanner.nextLine();
    System.out.print("Media file type (Audio/Video): ");
    String type = scanner.nextLine();
    MediaFile newMediaFile = new MediaFile(id, name, type);
    try {
      mediaFileService.addMediaFile(newMediaFile);
      System.out.println("\nMedia file created successfully!");
    } catch (Exception e) {
      System.out.println(RED + "Error: " + e.getMessage());
    }
    printAllMediaFiles();
  }

  private static void delMediaFile() {
    System.out.print("Enter the media file ID: ");
    String id = scanner.nextLine();
    try {
      Optional<MediaFile> optionalMedia = mediaFileService.getMediaFile(Integer.parseInt(id));
      if (optionalMedia.isPresent()) {
        MediaFile mediaFile = optionalMedia.get();
        mediaFileService.deleteMediaFile(mediaFile.getId());
        System.out.println("\nMedia file " + mediaFile.getId() + ": " + mediaFile.getName() + " deleted successfully!");
        printAllMediaFiles();
      } else {
        System.out.println(RED + "Media file with ID " + id + " not found.");
      }
    } catch (NumberFormatException e) {
      System.out.println(RED + "Invalid ID format: " + id);
    } catch (Exception e) {
      System.out.println(RED + "Error: " + e.getMessage());
    }
  }

  private static void changeMedia() {
    System.out.print("Enter the media file ID: ");
    String id = scanner.nextLine();
    Optional<MediaFile> optionalMediaFile = mediaFileService.getMediaFile(Integer.parseInt(id));
    if (optionalMediaFile.isPresent()) {
      MediaFile mediaFile = optionalMediaFile.get();
      String currentType = mediaFile.getType();
      String newType = (currentType.equals("Audio")) ? "Video" : "Audio";
      System.out.print("Do you want to change the type for " + mediaFile.getName()
              + " from " + currentType + " to " + newType + "? (Y/N): ");
      String answer = scanner.nextLine();
      if (answer.equalsIgnoreCase("Y")) {
        mediaFile.updateType(newType);
        mediaFileService.updateMediaFile(mediaFile);
        System.out.println("\nType for ID " + mediaFile.getId() + " changed from " + currentType
                + " to " + mediaFile.getType() + ".");
      } else {
        System.out.println("\nNothing has changed!");
      }
      printAllMediaFiles();
    }
  }

  private static void printAllUsers() {
    System.out.println(YELLOW + "\nHere is the list of all users:");
    for (org.example.entities.User user : users) {
      System.out.println(user.getId() + ": " + user.getUsername());
    }
  }

  private static Optional<User> getUserById() {
    System.out.print("Enter the user ID: ");
    String id = scanner.nextLine();
    try {
      Optional<User> optionalUser = userService.getUser(Integer.parseInt(id));
      if (optionalUser.isPresent()) {
        return optionalUser;
      } else {
        System.out.println(RED + "User with ID " + id + " not found.");
      }
    } catch (NumberFormatException e) {
      System.out.println(RED + "Invalid ID format: " + id);
    } catch (Exception e) {
      System.out.println(RED + "Error: " + e.getMessage());
    }
    return Optional.empty();
  }

  private static void printUserById() {
    Optional<User> optionalUser = getUserById();
    if (optionalUser.isPresent()) {
      User user = optionalUser.get();
      System.out.println(YELLOW + "\n" + user.getId() + ": " + user.getUsername());
    }
  }

  private static void addUser() {
    System.out.print("\nUser ID: ");
    int id = Integer.parseInt(scanner.nextLine());
    System.out.print("Username: ");
    String username = scanner.nextLine();
    System.out.print("Password: ");
    String password = scanner.nextLine();
    User newUser = new User(id, username, password, false);
    try {
      userService.createUser(newUser);
      System.out.println("\nUser created successfully!");
    } catch (Exception e) {
      System.out.println(RED + "Error: " + e.getMessage());
    }
    printAllUsers();
  }

  private static void delUser() {
    Optional<User> optionalUser = getUserById();
    if (optionalUser.isPresent()) {
      User user = optionalUser.get();
      userService.deleteUser(user.getId());
      System.out.println("\nUser " + user.getId() + ": " + user.getUsername() + " deleted successfully!");
      printAllUsers();
    }
  }

  private static void changeUsername() {
    Optional<User> optionalUser = getUserById();
    if (optionalUser.isPresent()) {
      User user = optionalUser.get();
      String oldUsername = user.getUsername();
      System.out.print("Enter new username for " + oldUsername + ": ");
      String newUsername = scanner.nextLine();
      user.setUsername(newUsername);
      userService.updateUser(user);
      System.out.println("\nUsername for ID " + user.getId() + " changed from " + oldUsername
              + " to " + user.getUsername());
      printAllUsers();
    }
  }

  private static void changePassword() {
    Optional<User> optionalUser = getUserById();
    if (optionalUser.isPresent()) {
      User user = optionalUser.get();
      String oldPassword = user.getPassword();
      String inputPassword = "";
      String confirmPassword = "";
      String newPassword = "";
      do {
        System.out.print("Enter current password for " + user.getUsername() + ": ");
        inputPassword = scanner.nextLine();
        if (!inputPassword.equals(oldPassword)) {
          System.out.println(RED + "Password is wrong! Try again." + BLUE);
        }
      } while (!inputPassword.equals(oldPassword));
      do {
        System.out.print("Enter new password: ");
        newPassword = scanner.nextLine();
        System.out.print("Re-enter new password: ");
        confirmPassword = scanner.nextLine();
        if (!newPassword.equals(confirmPassword)) {
          System.out.println(RED + "Password doesn't match! Try again." + BLUE);
        }
      } while (!newPassword.equals(confirmPassword));
      user.setPassword(newPassword);
      userService.updateUser(user);
      System.out.println("\nPassword for " + user.getUsername() + " changed successfully.");
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
        playlist.playMedia(1);
      } else {
        System.out.println(RED + "Playlist with ID " + id + " not found.");
      }
    } catch (NumberFormatException e) {
      System.out.println(RED + "Invalid ID format: " + id);
    } catch (Exception e) {
      System.out.println(RED + "Error: " + e.getMessage());
    }
  }

  private static void printUserPlaylists() {
    System.out.print("Enter the user ID: ");
    String id = scanner.nextLine();
    try {
      Optional<User> optionalUser = userService.getUser(Integer.parseInt(id));
      if (optionalUser.isPresent()) {
        User user = optionalUser.get();
        if (user.getPlaylists().isEmpty()) {
          System.out.println(RED + "\nThere is no playlist for user " + user.getUsername() + ".");
        } else {
          for (Playlist userPlaylist : user.getPlaylists()) {
            System.out.println(" - " + userPlaylist.getName());
          }
        }
      } else {
        System.out.println(RED + "User with ID " + id + " not found.");
      }
    } catch (NumberFormatException e) {
      System.out.println(RED + "Invalid ID format: " + id);
    } catch (Exception e) {
      System.out.println(RED + "Error: " + e.getMessage());
    }
  }

  private static void addUserPlaylists() {
    System.out.print("Enter the user ID: ");
    String id = scanner.nextLine();
    try {
      Optional<User> optionalUser = userService.getUser(Integer.parseInt(id));
      if (optionalUser.isPresent()) {
        User user = optionalUser.get();
        System.out.print("Enter the playlist ID to add to user " + user.getUsername() + ": ");
        String playlistId = scanner.nextLine();
        try {
          Optional<Playlist> optionalPlaylist = playlistService.getPlaylist(Integer.parseInt(playlistId));
          if (optionalPlaylist.isPresent()) {
            Playlist playlist = optionalPlaylist.get();
            user.addPlaylist(playlist);
            System.out.println(YELLOW + "Playlist added successfully!\n\n" + user.getUsername() + "'s playlist(s): ");
            for (Playlist userPlaylist : user.getPlaylists()) {
              System.out.println(" - " + userPlaylist.getName());
            }
          } else {
            System.out.println(RED + "Playlist with ID " + playlistId + " not found.");
          }
        } catch (NumberFormatException e) {
          System.out.println(RED + "Invalid playlist ID format: " + playlistId);
        } catch (Exception e) {
          System.out.println(RED + "Error: " + e.getMessage());
        }
      } else {
        System.out.println(RED + "User with ID " + id + " not found.");
      }
    } catch (NumberFormatException e) {
      System.out.println(RED + "Invalid user ID format: " + id);
    } catch (Exception e) {
      System.out.println(RED + "Error: " + e.getMessage());
    }
  }

  private static void removeUserPlaylist() {
    System.out.print("Enter the user ID: ");
    String id = scanner.nextLine();
    try {
      Optional<User> optionalUser = userService.getUser(Integer.parseInt(id));
      if (optionalUser.isPresent()) {
        User user = optionalUser.get();
        System.out.print("Enter the playlist ID to remove from user " + user.getUsername() + ": ");
        String playlistId = scanner.nextLine();
        try {
          Optional<Playlist> optionalPlaylist = playlistService.getPlaylist(Integer.parseInt(playlistId));
          if (optionalPlaylist.isPresent()) {
            Playlist playlist = optionalPlaylist.get();
            user.removePlaylist(playlist);
            System.out.println(YELLOW + "Playlist removed successfully!\n\n" + user.getUsername() + "'s playlist(s): ");
            if (user.getPlaylists().isEmpty()) {
              System.out.println(RED + "\nThere is no playlist for user " + user.getUsername() + ".");
            }
            for (Playlist userPlaylist : user.getPlaylists()) {
              System.out.println(" - " + userPlaylist.getName());
            }
          } else {
            System.out.println(RED + "Playlist with ID " + playlistId + " not found.");
          }
        } catch (NumberFormatException e) {
          System.out.println(RED + "Invalid playlist ID format: " + playlistId);
        } catch (Exception e) {
          System.out.println(RED + "Error: " + e.getMessage());
        }
      } else {
        System.out.println(RED + "User with ID " + id + " not found.");
      }
    } catch (NumberFormatException e) {
      System.out.println(RED + "Invalid user ID format: " + id);
    } catch (Exception e) {
      System.out.println(RED + "Error: " + e.getMessage());
    }
  }

  private static void login() {
    boolean isLoggedIn = false;
    do {
      System.out.print(BLUE + "\nEnter your username: ");
      String username = scanner.nextLine();
      System.out.print("And password: ");
      String password = scanner.nextLine();
      Optional<User> optionalUser = userService.listUsers().stream()
              .filter(user -> user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password))
              .findFirst();
      if (optionalUser.isPresent()) {
        User user = optionalUser.get();
        isLoggedIn = true;
        System.out.println("Welcome, " + user.getUsername() + "!");
        if (user.isAdmin()) {
          showAdminMenu();
        } else {
          showUserMenu();
        }
      } else {
        System.out.println(RED + "Invalid username or password. Please try again." + BLUE);
      }
    } while (!isLoggedIn);
  }

  private static void showUserMenu() {
    String choice = "";
    while (!choice.equalsIgnoreCase("Q")) {
      System.out.println(YELLOW + "\n=== User Menu ===");

      System.out.println(BLUE + "\n(1) Add media file");
      System.out.println("(2) Remove media file");
      System.out.println("(3) Play media file");
      System.out.println("(4) Pause media file");
      System.out.println("(5) Stop media file");

      System.out.println(RED + "(Q) Quit");
      System.out.println(BLUE + "\nEnter your choice: ");
      choice = scanner.nextLine().toUpperCase();

      switch (choice) {
        case "1" -> System.out.println(1);
        case "2" -> System.out.println(2);
        case "3" -> addNewMediaFile();
        case "4" -> System.out.println(4);
        case "5" -> System.out.println(5);
        case "Q" -> System.out.println(RED + "Exiting the app...");
        default -> System.out.println(RED + "Invalid choice, try again!");
      }
    }
  }

  private static void showAdminMenu() {
    String choice = "";
    while (!choice.equalsIgnoreCase("Q")) {
      System.out.println(YELLOW + "\n=== Admin Menu ===");
      System.out.println(BLUE + "\n(1) Show all media files");
      System.out.println("(2) Show media file by ID");
      System.out.println("(3) Add media file");
      System.out.println("(4) Delete media file");
      System.out.println("(5) Update media file");
      System.out.println("\n(6) Show all users");
      System.out.println("(7) Show user by ID");
      System.out.println("(8) Add user");
      System.out.println("(9) Delete user");
      System.out.println("(A) Change username");
      System.out.println("(B) Change password");
      System.out.println("\n(C) Show user's playlists");
      System.out.println("(D) Add playlist for user");
      System.out.println("(E) Remove playlist from user");
      System.out.println("(F) Show all playlists");
      System.out.println("(G) Show playlist by ID");
      System.out.println(RED + "(Q) Quit");
      System.out.println(BLUE + "\nEnter your choice: ");
      choice = scanner.nextLine().toUpperCase();

      switch (choice) {
        case "1" -> printAllMediaFiles();
        case "2" -> printMediaFileById();
        case "3" -> addNewMediaFile();
        case "4" -> delMediaFile();
        case "5" -> changeMedia();
        case "6" -> printAllUsers();
        case "7" -> printUserById();
        case "8" -> addUser();
        case "9" -> delUser();
        case "A" -> changeUsername();
        case "B" -> changePassword();
        case "C" -> printUserPlaylists();
        case "D" -> addUserPlaylists();
        case "E" -> removeUserPlaylist();
        case "F" -> printAllPlaylists();
        case "G" -> printPlaylistById();
        case "Q" -> System.out.println(RED + "Exiting the app...");
        default -> System.out.println(RED + "Invalid choice, try again!");
      }
    }

  }
}