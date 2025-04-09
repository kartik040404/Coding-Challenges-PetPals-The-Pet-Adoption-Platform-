package com.example.petpals.bal;

import com.example.petpals.dao.petdao.PetDAO;
import com.example.petpals.dao.petdao.PetDAOImpl;
import com.example.petpals.dao.shelterdao.ShelterDAO;
import com.example.petpals.dao.shelterdao.ShelterDAOImpl;
import com.example.petpals.exception.InvalidPetAgeException;
import com.example.petpals.exception.DetailsNotFoundException;
import com.example.petpals.model.Pet;

import java.sql.SQLException;
import java.util.List;

public class PetBal {
    static PetDAO petDAO;
    static ShelterBal shelterBal;
    static {
        petDAO=new PetDAOImpl();
        shelterBal=new ShelterBal();
    }
    public boolean checkPetID(int petID) throws SQLException, ClassNotFoundException, DetailsNotFoundException {
        if(petDAO.searchPetsByID(petID)==null){
            throw new DetailsNotFoundException("Pet ID not Found");
        }
        else return true;
    }
    public void addPetBal(Pet pet) throws SQLException, ClassNotFoundException {
        petDAO.addPet(pet);
    }
    public void removePetBal(int petID) throws SQLException, ClassNotFoundException, DetailsNotFoundException {
        if(checkPetID(petID)){
        petDAO.removePet(petID);
        }
        else return;
    }
    public List<Pet> showAvailablePetBal() throws SQLException, ClassNotFoundException {
        return petDAO.showAvailablePets();
    }
    public Pet searchPetByODBal(int petID) throws SQLException, ClassNotFoundException, DetailsNotFoundException {
        Pet pet=petDAO.searchPetsByID(petID);
        if(pet==null){
            throw new DetailsNotFoundException("Pet ID not Found");
        }
        else return pet;
    }
    public boolean checkEmpty(String string){
        if(string.trim().isEmpty()){
            return false;
        }
        return true;
    }
    public boolean checkAge(int age) throws InvalidPetAgeException {
        if(age<0){
            throw new InvalidPetAgeException("Invalid Age,age can not be negative");
        }
        else return true;
    }
    public boolean checkShelterID(int shelterID) throws DetailsNotFoundException, SQLException, ClassNotFoundException {
        if(shelterBal.checkShelterID(shelterID)){
            return true;
        }
        return false;
    }
}
