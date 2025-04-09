package com.example.petpals.dao.petdao;

import com.example.petpals.model.Pet;

import java.sql.SQLException;
import java.util.List;

public interface PetDAO {
        void addPet(Pet pet) throws SQLException, ClassNotFoundException;
        void removePet(int petID) throws SQLException, ClassNotFoundException;
        List<Pet> showAvailablePets() throws SQLException, ClassNotFoundException;
        Pet searchPetsByID(int petID) throws SQLException, ClassNotFoundException;
}
