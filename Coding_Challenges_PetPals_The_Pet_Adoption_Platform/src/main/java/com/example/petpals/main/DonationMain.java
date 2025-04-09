package com.example.petpals.main;

import com.example.petpals.bal.DonationBal;
import com.example.petpals.bal.ShelterBal;
import com.example.petpals.exception.DetailsNotFoundException;
import com.example.petpals.exception.InsufficientFundsException;
import com.example.petpals.exception.InvalidPetAgeException;
import com.example.petpals.model.Donation;
import com.example.petpals.model.Shelter;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DonationMain {
    DonationBal donationBal;
    Scanner sc;

    DonationMain() {
        donationBal = new DonationBal();
        sc = new Scanner(System.in);
    }


    public void addDonationMain() throws InvalidPetAgeException, SQLException, ClassNotFoundException, InsufficientFundsException, ParseException {
        Donation donation = new Donation();
        String type;
        System.out.println("Enter Donor Name: ");
        donation.setDonorname(sc.nextLine());
        System.out.print("Enter Donor Type (Cash/Item): ");
        type = sc.next();
        donation.setDonationtype(type);
        if (type.equals("Cash")) {
            do {
                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();
                try{
                if (donationBal.checkAmount(amount)) {
                    donation.setDonationamount(amount);
                    break;
                }
                }catch (InsufficientFundsException e){
                    System.out.print(e.getMessage());
                }
            } while (true);
            sc.nextLine();
        }
        else {
            sc.nextLine();
            System.out.print("Enter item: ");
            donation.setDonationitem(sc.nextLine());
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Enter date (yyyy-MM-dd HH:mm:ss): ");
        String date=sc.nextLine();
        donation.setDonationdate(sdf.parse(date));
        donationBal.addDonationBal(donation);
    }

    public void removeDonationMain() throws SQLException, ClassNotFoundException, ParseException {
        int donationID;
        System.out.println("Enter Donation ID");
        donationID = sc.nextInt();
        try {
            donationBal.removeDonationBal(donationID);
        } catch (DetailsNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public void showDonationMain() throws SQLException, ClassNotFoundException, ParseException {
        List<Donation> donationList = new ArrayList<>();
        donationList = donationBal.showDonationBal();
        if (!donationList.isEmpty()) {
            for (Donation donation : donationList) {
                System.out.println(donation);
            }
        } else System.out.println("No records found");
    }

    public void searchDonationByIDMain() throws SQLException, ClassNotFoundException, DetailsNotFoundException, ParseException {
        int donationID;
        System.out.println("Enter Donation ID:");
        donationID = sc.nextInt();
        try {
            Donation donation = donationBal.searchDonationByODBal(donationID);
            System.out.println(donation);
        } catch (DetailsNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
