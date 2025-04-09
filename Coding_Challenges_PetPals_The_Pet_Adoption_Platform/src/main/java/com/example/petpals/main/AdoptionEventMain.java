package com.example.petpals.main;

import com.example.petpals.bal.AdoptionEventBal;
import com.example.petpals.bal.DonationBal;
import com.example.petpals.exception.DetailsNotFoundException;
import com.example.petpals.exception.InsufficientFundsException;
import com.example.petpals.exception.InvalidPetAgeException;
import com.example.petpals.model.AdoptionEvent;
import com.example.petpals.model.Donation;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdoptionEventMain {
    AdoptionEventBal adoptionEventBal;
    Scanner sc;

    AdoptionEventMain() {
        adoptionEventBal = new AdoptionEventBal();
        sc = new Scanner(System.in);
    }


    public void addAdoptionEventMain() throws InvalidPetAgeException, SQLException, ClassNotFoundException, InsufficientFundsException, ParseException {
        AdoptionEvent adoptionEvent = new AdoptionEvent();
        String type;
        System.out.println("Enter Event Name: ");
        adoptionEvent.setEventName(sc.nextLine());
//        sc.nextLine();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Enter event date (yyyy-MM-dd HH:mm:ss): ");
        String date=sc.nextLine();
        adoptionEvent.setEventDate(sdf.parse(date));
        System.out.println("Enter Location: ");
        adoptionEvent.setLocation(sc.nextLine());
        adoptionEventBal.addPetAdoptionEventBal(adoptionEvent);
    }

    public void removeAdoptionMain() throws SQLException, ClassNotFoundException, ParseException {
        int adoptionEventID;
        System.out.println("Enter Event ID");
        adoptionEventID = sc.nextInt();
        try {
            adoptionEventBal.removeAdoptionEventBal(adoptionEventID);
        } catch (DetailsNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public void showAdoptionMain() throws SQLException, ClassNotFoundException, ParseException {
        List<AdoptionEvent> adoptionEventList = new ArrayList<>();
        adoptionEventList = adoptionEventBal.showAdoptionEventBal();
        if (!adoptionEventList.isEmpty()) {
            for (AdoptionEvent adoptionEvent : adoptionEventList) {
                System.out.println(adoptionEvent);
            }
        } else System.out.println("No records found");
    }

    public void searchAdoptionEventByIDMain() throws SQLException, ClassNotFoundException, DetailsNotFoundException, ParseException {
        int adoptionEventID;
        System.out.println("Enter Event ID:");
        adoptionEventID = sc.nextInt();
        try {
            AdoptionEvent adoptionEvent = adoptionEventBal.searchAdoptionEventByODBal(adoptionEventID);
            System.out.println(adoptionEvent);
        } catch (DetailsNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
