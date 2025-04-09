package com.example.petpals.dao.petdao;

import com.example.petpals.model.Pet;
import com.example.petpals.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDAOImpl implements PetDAO{
static Connection connection;
static PreparedStatement preparedStatement;
    @Override
    public void addPet(Pet pet) throws SQLException, ClassNotFoundException {
        connection= ConnectionHelper.getConnection();
        String stmt="Insert into pets (name,age,breed,type,available,shelterid) values(?,?,?,?,?,?)";
        preparedStatement=connection.prepareStatement(stmt);
        preparedStatement.setString(1,pet.getName());
        preparedStatement.setInt(2,pet.getAge());
        preparedStatement.setString(3,pet.getBreed());
        preparedStatement.setString(4,pet.getType());
        preparedStatement.setBoolean(5,pet.isAvailable());
        preparedStatement.setInt(6,pet.getShelterid());
        int rowsInserted=preparedStatement.executeUpdate();
        if(rowsInserted>0){
            System.out.println("Pet Details inserted successfully");
        }
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void removePet(int petID) throws SQLException, ClassNotFoundException {
        String stmt="Delete from pets where petid=?";
        connection=ConnectionHelper.getConnection();
        preparedStatement=connection.prepareStatement(stmt);
        preparedStatement.setInt(1,petID);
        int rowsDeleted=preparedStatement.executeUpdate();
        if(rowsDeleted>0){
            System.out.println("Pet details deleted successfully");
        }
        connection.close();
        preparedStatement.close();
    }

    @Override
    public List<Pet> showAvailablePets() throws SQLException, ClassNotFoundException {
        connection=ConnectionHelper.getConnection();
        String stmt="Select * from pets where available=1";
        preparedStatement=connection.prepareStatement(stmt);
        ResultSet resultSet=preparedStatement.executeQuery();
        List<Pet> petList=new ArrayList<>();
        Pet pet=null;
        while (resultSet.next()){
            pet=new Pet();
            pet.setPedid(resultSet.getInt("petid"));
            pet.setName(resultSet.getString("name"));
            pet.setAge(resultSet.getInt("age"));
            pet.setBreed(resultSet.getString("breed"));
            pet.setAvailable(resultSet.getBoolean("available"));
            pet.setType(resultSet.getString("type"));
            pet.setShelterid(resultSet.getInt("shelterid"));
            petList.add(pet);
        }
        connection.close();
        preparedStatement.close();
        return petList;
    }

    @Override
    public Pet searchPetsByID(int petID) throws SQLException, ClassNotFoundException {
        connection=ConnectionHelper.getConnection();
        String stmt="Select * from pets where petid=?";
        preparedStatement=connection.prepareStatement(stmt);
        preparedStatement.setInt(1,petID);
        ResultSet resultSet=preparedStatement.executeQuery();
        Pet pet=null;
        if(resultSet.next()){
            pet=new Pet();
            pet.setPedid(resultSet.getInt("petid"));
            pet.setName(resultSet.getString("name"));
            pet.setAge(resultSet.getInt("age"));
            pet.setBreed(resultSet.getString("breed"));
            pet.setAvailable(resultSet.getBoolean("available"));
            pet.setType(resultSet.getString("type"));
            pet.setShelterid(resultSet.getInt("shelterid"));
        }
        connection.close();
        preparedStatement.close();
        return pet;
    }
}
