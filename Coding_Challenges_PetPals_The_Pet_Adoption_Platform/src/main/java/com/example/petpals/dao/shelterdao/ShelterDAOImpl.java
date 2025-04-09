package com.example.petpals.dao.shelterdao;

import com.example.petpals.model.Pet;
import com.example.petpals.model.Shelter;
import com.example.petpals.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShelterDAOImpl implements ShelterDAO {
    static Connection connection;
    static PreparedStatement preparedStatement;

    @Override
    public void addShelter(Shelter shelter) throws SQLException, ClassNotFoundException {
        connection = ConnectionHelper.getConnection();
        String stmt = "Insert into shelters (name,location) values(?,?)";
        preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.setString(1, shelter.getName());
        preparedStatement.setString(2, shelter.getLocation());
        int rowsInserted = preparedStatement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Shelter Details inserted successfully");
        }
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void removeShelter(int shelterID) throws SQLException, ClassNotFoundException {
        String stmt = "Delete from shelters where shelterid=?";
        connection = ConnectionHelper.getConnection();
        preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.setInt(1, shelterID);
        int rowsDeleted = preparedStatement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Shelter details deleted successfully");
        }
        connection.close();
        preparedStatement.close();
    }

    @Override
    public List<Shelter> showShelter() throws SQLException, ClassNotFoundException {
        connection = ConnectionHelper.getConnection();
        String stmt = "Select * from shelters";
        preparedStatement = connection.prepareStatement(stmt);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Shelter> shelterList = new ArrayList<>();
        Shelter shelter = null;
        while (resultSet.next()) {
            shelter = new Shelter();
            shelter.setShelterid(resultSet.getInt("shelterid"));
            shelter.setName(resultSet.getString("name"));
            shelter.setLocation(resultSet.getString("location"));
            shelterList.add(shelter);
        }
        connection.close();
        preparedStatement.close();
        return shelterList;
    }

    @Override
    public Shelter searchShelterByID(int shelterID) throws SQLException, ClassNotFoundException {
        connection = ConnectionHelper.getConnection();
        String stmt = "Select * from shelters where shelterid=?";
        preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.setInt(1, shelterID);
        ResultSet resultSet = preparedStatement.executeQuery();
        Shelter shelter = null;
        if (resultSet.next()) {
            shelter = new Shelter();
            shelter.setShelterid(resultSet.getInt("shelterid"));
            shelter.setName(resultSet.getString("name"));
            shelter.setLocation(resultSet.getString("location"));
        }
        connection.close();
        preparedStatement.close();
        return shelter;

    }
}
