package com.example.petpals.main;

import com.example.petpals.bal.ShelterBal;
import com.example.petpals.exception.InvalidPetAgeException;
import com.example.petpals.exception.DetailsNotFoundException;
import com.example.petpals.model.Pet;
import com.example.petpals.model.Shelter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShelterMain {
    ShelterBal shelterBal;
    Scanner sc;

    ShelterMain() {
        shelterBal = new ShelterBal();
        sc = new Scanner(System.in);
    }

    public void addShelterMain() throws InvalidPetAgeException, SQLException, ClassNotFoundException {
        Shelter shelter = new Shelter();
        String name, breed, type;
        int age, shelterID;
        String available;
        System.out.print("Enter Shelter Name: ");
        shelter.setName(sc.nextLine());
        System.out.print("Enter Shelter Location: ");
        shelter.setLocation(sc.nextLine());
        shelterBal.addPetShelterBal(shelter);
    }

    public void removeShelterMain() throws SQLException,ClassNotFoundException{
        int shelterID;
        System.out.println("Enter Shelter ID");
        shelterID = sc.nextInt();
        try {
            shelterBal.removePetShelterBal(shelterID);
        } catch (DetailsNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public void showShelterMain() throws SQLException, ClassNotFoundException {
        List<Shelter> shelterList = new ArrayList<>();
        shelterList = shelterBal.showShelterBal();
        if (!shelterList.isEmpty()) {
            for (Shelter shelter : shelterList) {
                System.out.println(shelter);
            }
        } else System.out.println("No records found");
    }

    public void searchShelterByIDMain() throws SQLException, ClassNotFoundException, DetailsNotFoundException {
        int shelterID;
        System.out.println("Enter Shelter ID:");
        shelterID = sc.nextInt();
        try {
            Shelter shelter = shelterBal.searchShelterByODBal(shelterID);
//            if (customer != null)
            System.out.println(shelter);
//            else System.out.println("No customer found");
        } catch (DetailsNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
