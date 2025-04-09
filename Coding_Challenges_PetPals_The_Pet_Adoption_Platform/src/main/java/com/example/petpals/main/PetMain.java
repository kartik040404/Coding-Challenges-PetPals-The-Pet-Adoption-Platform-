package com.example.petpals.main;

import com.example.petpals.bal.PetBal;
import com.example.petpals.exception.InvalidPetAgeException;
import com.example.petpals.exception.DetailsNotFoundException;
import com.example.petpals.model.Pet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetMain {
    PetBal petBal;
    Scanner sc;

    PetMain() {
        petBal = new PetBal();
        sc = new Scanner(System.in);
    }

    public void addPetMain() throws InvalidPetAgeException, SQLException, ClassNotFoundException {
        Pet pet = new Pet();
        int age, shelterID;
        String available;

        System.out.println("Enter Pet Name: ");
        pet.setName(sc.nextLine());

        do {
            System.out.println("Enter Age: ");
            age = sc.nextInt();
            sc.nextLine(); // Consume the leftover newline
            try {
                if (petBal.checkAge(age)) {
                    break;
                }
            } catch (InvalidPetAgeException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        pet.setAge(age);

        System.out.println("Enter Breed: ");
        pet.setBreed(sc.nextLine());

        System.out.println("Enter Type (Dog/Cat): ");
        pet.setType(sc.next());
        sc.nextLine(); // Consume leftover newline

        System.out.println("Enter availability: (Yes/No)");
        available = sc.next();
        sc.nextLine(); // Consume leftover newline
        pet.setAvailable(available.equalsIgnoreCase("Yes"));
        do {
            System.out.println("Enter ShelterID: ");
            shelterID = sc.nextInt();
            try {
                if (petBal.checkShelterID(shelterID)) {
                    pet.setShelterid(shelterID);
                    break;
                }
            } catch (DetailsNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        petBal.addPetBal(pet);
    }


    public void removePetMain() throws SQLException, ClassNotFoundException {
        int petID;
        System.out.println("Enter Pet ID");
        petID = sc.nextInt();
        try {
            petBal.removePetBal(petID);
        } catch (DetailsNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public void showAvailablePetMain() throws SQLException, ClassNotFoundException {
        List<Pet> petList = new ArrayList<>();
        petList = petBal.showAvailablePetBal();
        if (!petList.isEmpty()) {
            for (Pet pet : petList) {
                System.out.println(pet);
            }
        } else System.out.println("No records found");
    }

    public void searchPetByIDMain() throws SQLException, ClassNotFoundException, DetailsNotFoundException {
        int petID;
        System.out.println("Enter Pet ID:");
        petID = sc.nextInt();
        try {
            Pet pet = petBal.searchPetByODBal(petID);
//            if (customer != null)
            System.out.println(pet);
//            else System.out.println("No customer found");
        } catch (DetailsNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
