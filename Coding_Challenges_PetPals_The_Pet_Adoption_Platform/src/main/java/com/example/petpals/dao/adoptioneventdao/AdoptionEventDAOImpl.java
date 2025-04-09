package com.example.petpals.dao.adoptioneventdao;

import com.example.petpals.model.AdoptionEvent;
import com.example.petpals.model.Donation;
import com.example.petpals.model.Pet;
import com.example.petpals.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AdoptionEventDAOImpl implements AdoptionEventDAO{
    static Connection connection;
    static PreparedStatement preparedStatement;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void addAdoptionEvent(AdoptionEvent adoptionEvent) throws SQLException, ClassNotFoundException {
        connection= ConnectionHelper.getConnection();
        String stmt="Insert into adoptionevents (eventname,eventdate,location) values(?,?,?)";
        preparedStatement=connection.prepareStatement(stmt);
        preparedStatement.setString(1,adoptionEvent.getEventName());
        preparedStatement.setString(2,sdf.format(adoptionEvent.getEventDate()));
        preparedStatement.setString(3,adoptionEvent.getLocation());
        int rowsInserted=preparedStatement.executeUpdate();
        if(rowsInserted>0){
            System.out.println("Event Details inserted successfully");
        }
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void removeAdoptionEvent(int adoptionEventID) throws SQLException, ClassNotFoundException {
        String stmt="Delete from adoptionevents";
        connection=ConnectionHelper.getConnection();
        preparedStatement=connection.prepareStatement(stmt);
        preparedStatement.setInt(1,adoptionEventID);
        int rowsDeleted=preparedStatement.executeUpdate();
        if(rowsDeleted>0){
            System.out.println("Event details deleted successfully");
        }
        connection.close();
        preparedStatement.close();
    }

    @Override
    public List<AdoptionEvent> showAdoptionEvent() throws SQLException, ClassNotFoundException, ParseException {
        connection=ConnectionHelper.getConnection();
        String stmt="Select * from adoptionevents";
        preparedStatement=connection.prepareStatement(stmt);
        ResultSet resultSet=preparedStatement.executeQuery();
        List<AdoptionEvent> adoptionEventList=new ArrayList<>();
        AdoptionEvent adoptionEvent=null;
        while (resultSet.next()){
            adoptionEvent=new AdoptionEvent();
            adoptionEvent.setEventID(resultSet.getInt("eventid"));
            adoptionEvent.setEventName(resultSet.getString("eventname"));
            adoptionEvent.setEventDate(sdf.parse(resultSet.getString("eventdate")));
            adoptionEvent.setLocation(resultSet.getString("location"));
            adoptionEventList.add(adoptionEvent);
        }
        connection.close();
        preparedStatement.close();
        return adoptionEventList;
    }

    @Override
    public AdoptionEvent searchAdoptionEventByID(int adoptionEventID) throws SQLException, ClassNotFoundException, ParseException {
            connection=ConnectionHelper.getConnection();
            String stmt="Select * from adoptionevents where eventid=?";
            preparedStatement=connection.prepareStatement(stmt);
            preparedStatement.setInt(1,adoptionEventID);
            ResultSet resultSet=preparedStatement.executeQuery();
            AdoptionEvent adoptionEvent=null;
            if(resultSet.next()){
                adoptionEvent=new AdoptionEvent();
                adoptionEvent.setEventID(resultSet.getInt("eventid"));
                adoptionEvent.setEventName(resultSet.getString("eventname"));
                adoptionEvent.setEventDate(sdf.parse(resultSet.getString("eventdate")));
                adoptionEvent.setLocation(resultSet.getString("location"));
            }
            connection.close();
            preparedStatement.close();
            return adoptionEvent;

    }
}
