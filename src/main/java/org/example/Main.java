package org.example;

import org.example.databases.Database;
import org.example.entities.MediaFile;
import org.example.repositories.MediaFileRepository;
import org.example.services.MediaFileService;

import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    final String RED = "\033[0;31m";
    final String BLUE = "\033[0;34m";
    final String YELLOW = "\033[0;33m";

    Database database = new Database();
    MediaFileRepository mediaFileRepository = new MediaFileRepository(database);
    MediaFileService mediaFileService = new MediaFileService(mediaFileRepository);
    List<MediaFile> mediaFiles = mediaFileService.listMediaFiles();

    Scanner scanner = new Scanner(System.in);
    String choice = "";
    while (!choice.equalsIgnoreCase("Q")) {
      System.out.println(BLUE + "\n1- Get all media files");
      System.out.println("2- User");
      System.out.println("3- Play List");
      System.out.println("Q- Quit");
      System.out.println(BLUE + "Enter your choice: ");
      choice = scanner.nextLine().toUpperCase();
      switch (choice) {
        case "1" -> {
          for (MediaFile mediaFile : mediaFiles) {
            System.out.println(YELLOW + mediaFile.getId() + ": " + mediaFile.getName() + " - " + mediaFile.getType());
          }
        }
        case "2" -> System.out.println("2");
        case "3" -> System.out.println("3");
        case "Q" -> System.out.println(RED + "Exiting the app...");
        default -> System.out.println(RED + "Invalid choice, try again!");
      }
    }
  }
}