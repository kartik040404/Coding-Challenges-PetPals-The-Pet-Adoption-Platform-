package com.example.petpals.bal;

import com.example.petpals.dao.participantsdao.ParticipantDAO;
import com.example.petpals.dao.participantsdao.ParticipantDAOImpl;
import com.example.petpals.dao.petdao.PetDAO;
import com.example.petpals.dao.petdao.PetDAOImpl;
import com.example.petpals.exception.DetailsNotFoundException;
import com.example.petpals.model.Donation;
import com.example.petpals.model.Participants;
import com.example.petpals.model.Pet;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ParticipantBal {
    static ParticipantDAO participantDAO;
    static AdoptionEventBal adoptionEventBal;
    static {
        participantDAO=new ParticipantDAOImpl();
        adoptionEventBal=new AdoptionEventBal();
    }
    public boolean checkParticipantID(int participantID) throws SQLException, ClassNotFoundException, DetailsNotFoundException {
        if(participantDAO.searchParticipantByID(participantID)==null){
            throw new DetailsNotFoundException("Participant Details not Found");
        }
        else return true;
    }
    public void addParticipantBal(Participants participants) throws SQLException, ClassNotFoundException {
        participantDAO.addParticipant(participants);
    }
    public void removeParticipantBal(int participantID) throws SQLException, ClassNotFoundException, DetailsNotFoundException {
        if(checkParticipantID(participantID)){
        participantDAO.removeParticipant(participantID);
        }
        else return;
    }
    public List<Participants> showParticipantBal() throws SQLException, ClassNotFoundException {
        return participantDAO.showParticipants();
    }

    public Participants searchParticipantByODBal(int participantID) throws SQLException, ClassNotFoundException, DetailsNotFoundException {
        Participants participants=participantDAO.searchParticipantByID(participantID);
        if(participants==null){
            throw new DetailsNotFoundException("Participant ID not Found");
        }
        else return participants;
    }

    public boolean checkEventID(int eventID) throws DetailsNotFoundException, SQLException, ClassNotFoundException, ParseException {
        if(adoptionEventBal.checkAdoptionEventID(eventID)){
            return true;
        }
        return false;
    }
}
