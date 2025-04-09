package com.example.petpals.main;

import com.example.petpals.bal.AdoptionEventBal;
import com.example.petpals.bal.ParticipantBal;
import com.example.petpals.exception.DetailsNotFoundException;
import com.example.petpals.exception.InsufficientFundsException;
import com.example.petpals.exception.InvalidPetAgeException;
import com.example.petpals.model.AdoptionEvent;
import com.example.petpals.model.Participants;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParticipantMain {
    ParticipantBal participantBal;
    Scanner sc;

    ParticipantMain() {
        participantBal = new ParticipantBal();
        sc = new Scanner(System.in);
    }


    public void addParticipantEventMain() throws InvalidPetAgeException, SQLException, ClassNotFoundException, InsufficientFundsException, ParseException {
        Participants participants = new Participants();
        String type;
        int eventID;
        System.out.println("Enter Participant Name: ");
        participants.setParticipantName(sc.nextLine());
        System.out.println("Enter Type (Shelter/Adopter): ");
        participants.setParticipantType(sc.next());
        do {
            System.out.println("Enter Event ID: ");
            eventID = sc.nextInt();
            try {
                if (participantBal.checkEventID(eventID)) {
                    participants.setEventID(eventID);
                    break;
                }
            } catch (DetailsNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        participantBal.addParticipantBal(participants);
    }

    public void removeParticipantMain() throws SQLException, ClassNotFoundException, ParseException {
        int participantID;
        System.out.println("Enter Participant ID");
        participantID = sc.nextInt();
        try {
            participantBal.removeParticipantBal(participantID);
        } catch (DetailsNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public void showParticipantMain() throws SQLException, ClassNotFoundException, ParseException {
        List<Participants> participantsList = new ArrayList<>();
        participantsList = participantBal.showParticipantBal();
        if (!participantsList.isEmpty()) {
            for (Participants participant : participantsList) {
                System.out.println(participant);
            }
        } else System.out.println("No records found");
    }

    public void searchParticipantEventByIDMain() throws SQLException, ClassNotFoundException, DetailsNotFoundException, ParseException {
        int participantID;
        System.out.println("Enter Participant ID:");
        participantID = sc.nextInt();
        try {
            Participants participants = participantBal.searchParticipantByODBal(participantID);
            System.out.println(participants);
        } catch (DetailsNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
