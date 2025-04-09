package com.example.petpals.dao.shelterdao;

import com.example.petpals.model.Pet;
import com.example.petpals.model.Shelter;

import java.sql.SQLException;
import java.util.List;

public interface ShelterDAO {
    void addShelter(Shelter shelter) throws SQLException, ClassNotFoundException;
    void removeShelter(int shelterID) throws SQLException, ClassNotFoundException;
    List<Shelter> showShelter() throws SQLException, ClassNotFoundException;
    Shelter searchShelterByID(int shelterID) throws SQLException, ClassNotFoundException;
}
