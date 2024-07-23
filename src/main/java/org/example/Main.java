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

  public static void main(String[] args) {

    Database database = new Database();

    MediaFileRepository mediaFileRepository = new MediaFileRepository(database);
    MediaFileService mediaFileService = new MediaFileService(mediaFileRepository);
    List<MediaFile> mediaFiles = mediaFileService.listMediaFiles();

    UserRepository userRepository = new UserRepository(database);
    UserService userService = new UserService(userRepository);
    List<User> users = userService.listUsers();

    Scanner scanner = new Scanner(System.in);
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
        case "1" -> printAllMediaFiles(mediaFiles);
        case "2" -> {
          System.out.print("Enter the ID: ");
          String id = scanner.nextLine();
          try {
            Optional<MediaFile> optionalMediaFile = mediaFileService.getMediaFile(Integer.parseInt(id));
            if (optionalMediaFile.isPresent()) {
              MediaFile mediaFile = optionalMediaFile.get();
              System.out.println(YELLOW + id + ": " + mediaFile.getName() + " - " + mediaFile.getType());
            } else {
              System.out.println(RED + "Media file with ID " + id + " not found.");
            }
          } catch (NumberFormatException e) {
            System.out.println(RED + "Invalid ID format: " + id);
          } catch (Exception e) {
            System.out.println(RED + "Error: " + e.getMessage());
          }
        }
        case "3" -> printAllUsers(users);
        case "Q" -> System.out.println(RED + "Exiting the app...");
        default -> System.out.println(RED + "Invalid choice, try again!");
      }
    }
  }

  private static void printAllMediaFiles(List<MediaFile> mediaFiles) {
    System.out.println(YELLOW + "\nHere is the list of all media files:");
    for (MediaFile mediaFile : mediaFiles) {
      System.out.println(mediaFile.getId() + ": " + mediaFile.getName() + " - " + mediaFile.getType());
    }
  }

  private static void printAllUsers(List<User> users) {
    System.out.println(YELLOW + "\nHere is the list of all users:");
    for (org.example.entities.User user : users) {
      System.out.println(user.getId() + ": " + user.getUsername());
    }
  }

  //  private List<User> getUserById(){
//    return
//  }

}