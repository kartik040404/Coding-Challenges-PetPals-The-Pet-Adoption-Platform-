package com.example.petpals.main;

import com.example.petpals.exception.InsufficientFundsException;
import com.example.petpals.exception.InvalidPetAgeException;
import com.example.petpals.exception.DetailsNotFoundException;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class PetPalsMain {
    static int ch;
    static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException, InvalidPetAgeException, DetailsNotFoundException, InsufficientFundsException {
        int choice;
        do {
            System.out.println("****** WELCOME TO PETPALS ******");
            System.out.println("Enter your choice:");
            System.out.println("1) Pet");
            System.out.println("2) Shelter");
            System.out.println("3) Donations");
            System.out.println("4) Adoption Events");
            System.out.println("5) Participants");
            System.out.println("6) Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    PetMain petMain=new PetMain();
                    do {
                        System.out.println("* Pet");
                        System.out.println("1) Add New Pet");
                        System.out.println("2) Remove Pet Record");
                        System.out.println("3) Show Available Pets");
                        System.out.println("4) Search Pet Details");
                        System.out.println("5) Exit");
                        ch = scanner.nextInt();
                        switch (ch) {
                            case 1:
                                petMain.addPetMain();
                                break;
                            case 2:
                                petMain.removePetMain();
                                break;
                            case 3:
                                petMain.showAvailablePetMain();
                                break;
                            case 4:
                                petMain.searchPetByIDMain();
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Wrong choice,Please enter valid choice");
                        }
                    } while (ch != 5);
                    break;

                case 2:
                    ShelterMain shelterMain=new ShelterMain();
                    do {
                        System.out.println("* Shelter");
                        System.out.println("1) Add Shelter");
                        System.out.println("2) Remove Shelter Record");
                        System.out.println("3) Show Shelter");
                        System.out.println("4) Search Shelter Details");
                        System.out.println("5) Exit");
                        ch = scanner.nextInt();
                        switch (ch) {
                            case 1:
                                shelterMain.addShelterMain();
                                break;
                            case 2:
                                shelterMain.removeShelterMain();
                                break;
                            case 3:
                                shelterMain.showShelterMain();
                                break;
                            case 4:
                                shelterMain.searchShelterByIDMain();
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Wrong choice,Please enter valid choice");
                        }
                    } while (ch != 5);
                    break;

                    case 3:
                    DonationMain donationMain=new DonationMain();
                    do {
                        System.out.println("* Donation");
                        System.out.println("1) Add Donation Details");
                        System.out.println("2) Remove Donation Record");
                        System.out.println("3) Show Donations list");
                        System.out.println("4) Search Donation Details");
                        System.out.println("5) Exit");
                        ch = scanner.nextInt();
                        switch (ch) {
                            case 1:
                                donationMain.addDonationMain();
                                break;
                            case 2:
                                donationMain.removeDonationMain();
                                break;
                            case 3:
                                donationMain.showDonationMain();
                                break;
                            case 4:
                                donationMain.searchDonationByIDMain();
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Wrong choice,Please enter valid choice");
                        }
                    } while (ch != 5);
                    break;

                    case 4:
                    AdoptionEventMain adoptionEventMain=new AdoptionEventMain();
                    do {
                        System.out.println("* Adoption Event");
                        System.out.println("1) Add Adoption Event");
                        System.out.println("2) Remove Adoption Event Record");
                        System.out.println("3) Show Adoption Event list");
                        System.out.println("4) Search Adoption Event Details");
                        System.out.println("5) Exit");
                        ch = scanner.nextInt();
                        switch (ch) {
                            case 1:
                                adoptionEventMain.addAdoptionEventMain();
                                break;
                            case 2:
                                adoptionEventMain.removeAdoptionMain();
                                break;
                            case 3:
                                adoptionEventMain.showAdoptionMain();
                                break;
                            case 4:
                                adoptionEventMain.searchAdoptionEventByIDMain();
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Wrong choice,Please enter valid choice");
                        }
                    } while (ch != 5);
                    break;

                    case 5:
                    ParticipantMain participantMain=new ParticipantMain();
                    do {
                        System.out.println("* Participant");
                        System.out.println("1) Register Participant");
                        System.out.println("2) Remove Participant Record");
                        System.out.println("3) Show Participant list");
                        System.out.println("4) Search Participant Details");
                        System.out.println("5) Exit");
                        ch = scanner.nextInt();
                        switch (ch) {
                            case 1:
                                participantMain.addParticipantEventMain();
                                break;
                            case 2:
                                participantMain.removeParticipantMain();
                                break;
                            case 3:
                                participantMain.showParticipantMain();
                                break;
                            case 4:
                                participantMain.searchParticipantEventByIDMain();
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Wrong choice,Please enter valid choice");
                        }
                    } while (ch != 5);
                    break;


                case 6:
                    return;
                default:
                    System.out.println("Wrong choice,please enter valid choice");
            }
        } while (choice != 6);
    }
}
