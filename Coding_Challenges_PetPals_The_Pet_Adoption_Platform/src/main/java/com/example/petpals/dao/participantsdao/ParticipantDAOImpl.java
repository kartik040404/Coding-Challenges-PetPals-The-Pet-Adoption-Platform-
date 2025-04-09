package com.example.petpals.dao.participantsdao;

import com.example.petpals.model.Donation;
import com.example.petpals.model.Participants;
import com.example.petpals.model.Pet;
import com.example.petpals.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAOImpl implements ParticipantDAO{
    static Connection connection;
    static PreparedStatement preparedStatement;
    @Override
    public void addParticipant(Participants participants) throws SQLException, ClassNotFoundException {
        connection= ConnectionHelper.getConnection();
        String stmt="Insert into participants (participantname,participanttype,eventid) values(?,?,?)";
        preparedStatement=connection.prepareStatement(stmt);
        preparedStatement.setString(1,participants.getParticipantName());
        preparedStatement.setString(2,participants.getParticipantType());
        preparedStatement.setInt(3,participants.getEventID());
        int rowsInserted=preparedStatement.executeUpdate();
        if(rowsInserted>0){
            System.out.println("Participants registered successfully");
        }
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void removeParticipant(int participantID) throws SQLException, ClassNotFoundException {
        String stmt="Delete from participants where participantid=?";
        connection=ConnectionHelper.getConnection();
        preparedStatement=connection.prepareStatement(stmt);
        preparedStatement.setInt(1,participantID);
        int rowsDeleted=preparedStatement.executeUpdate();
        if(rowsDeleted>0){
            System.out.println("Participant record deleted successfully");
        }
        connection.close();
        preparedStatement.close();
    }

    @Override
    public List<Participants> showParticipants() throws SQLException, ClassNotFoundException {
        connection=ConnectionHelper.getConnection();
        String stmt="Select * from participants";
        preparedStatement=connection.prepareStatement(stmt);
        ResultSet resultSet=preparedStatement.executeQuery();
        List<Participants> participantsList=new ArrayList<>();
        Participants participants=null;
        while (resultSet.next()){
            participants=new Participants();
            participants.setParticipantID(resultSet.getInt("participantid"));
            participants.setParticipantName(resultSet.getString("participantname"));
            participants.setParticipantType(resultSet.getString("participanttype"));
            participants.setEventID(resultSet.getInt("eventid"));
            participantsList.add(participants);
        }
        connection.close();
        preparedStatement.close();
        return participantsList;
    }

    @Override
    public Participants searchParticipantByID(int participantID) throws SQLException, ClassNotFoundException {
        connection=ConnectionHelper.getConnection();
        String stmt="Select * from participants where participantid=?";
        preparedStatement=connection.prepareStatement(stmt);
        preparedStatement.setInt(1,participantID);
        ResultSet resultSet=preparedStatement.executeQuery();
        Participants participants=null;
        if(resultSet.next()){
            participants=new Participants();
            participants.setParticipantID(resultSet.getInt("participantid"));
            participants.setParticipantName(resultSet.getString("participantname"));
            participants.setParticipantType(resultSet.getString("participanttype"));
            participants.setEventID(resultSet.getInt("eventid"));
        }
        connection.close();
        preparedStatement.close();
        return participants;
    }
}
