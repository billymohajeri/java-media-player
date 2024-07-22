package org.example;

import org.example.database.Database;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("Enter your choice:");
    System.out.println("1- Media file");
    System.out.println("2- User");
    System.out.println("3- Play List");
    System.out.println("Q- Quit");
    Scanner scanner = new Scanner(System.in);
    String choice = "";
    while (!choice.equalsIgnoreCase("Q")) {
      choice = scanner.nextLine().toUpperCase();
      switch (choice) {
        case "1" -> System.out.println("1");
        case "2" -> System.out.println("2");
        case "3" -> System.out.println("3");
        case "Q" -> System.out.println("Exiting the app...");
        default -> System.out.println("Invalid choice, try again!");
      }
    }

    Database database = new Database();

  }
}