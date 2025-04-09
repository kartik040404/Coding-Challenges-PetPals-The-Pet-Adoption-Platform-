package com.example.petpals.dao.participantsdao;

import com.example.petpals.model.Donation;
import com.example.petpals.model.Participants;
import com.example.petpals.model.Pet;

import java.sql.SQLException;
import java.util.List;

public interface ParticipantDAO {
    void addParticipant(Participants participants) throws SQLException, ClassNotFoundException;
    void removeParticipant(int participantID) throws SQLException, ClassNotFoundException;
    List<Participants> showParticipants() throws SQLException, ClassNotFoundException;
    Participants searchParticipantByID(int participantID) throws SQLException, ClassNotFoundException;

}
