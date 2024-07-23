package org.example;

import org.example.databases.Database;
import org.example.entities.MediaFile;
import org.example.entities.User;
import org.example.repositories.MediaFileRepository;
import org.example.repositories.UserRepository;
import org.example.services.MediaFileService;
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
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String choice = "";
    while (!choice.equalsIgnoreCase("Q")) {
      System.out.println(BLUE + "\n1- Get all media files");
      System.out.println("2- Get media file by ID");
      System.out.println("3- Get all users");
      System.out.println("4- Get user by ID");
      System.out.println("Q- Quit");
      System.out.println(BLUE + "Enter your choice: ");
      choice = scanner.nextLine().toUpperCase();

      switch (choice) {
        case "1" -> printAllMediaFiles();
        case "2" -> printMediaFileById();
        case "3" -> printAllUsers();
        case "4" -> printUserById();
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

}