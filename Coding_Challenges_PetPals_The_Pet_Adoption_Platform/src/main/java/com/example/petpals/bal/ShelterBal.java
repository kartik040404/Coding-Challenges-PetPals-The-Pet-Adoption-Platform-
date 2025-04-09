package com.example.petpals.bal;

import com.example.petpals.dao.shelterdao.ShelterDAO;
import com.example.petpals.dao.shelterdao.ShelterDAOImpl;
import com.example.petpals.exception.DetailsNotFoundException;
import com.example.petpals.model.Pet;
import com.example.petpals.model.Shelter;

import java.sql.SQLException;
import java.util.List;

public class ShelterBal {
    static ShelterDAO shelterDAO;
    static {
        shelterDAO=new ShelterDAOImpl();
    }
    public boolean checkShelterID(int shelterID) throws SQLException, ClassNotFoundException, DetailsNotFoundException {
        if(shelterDAO.searchShelterByID(shelterID)==null){
            throw new DetailsNotFoundException("Shelter ID not Found");
        }
        else return true;
    }
    public void addPetShelterBal(Shelter shelter) throws SQLException, ClassNotFoundException {
        shelterDAO.addShelter(shelter);
    }
    public void removePetShelterBal(int shelterID) throws SQLException, ClassNotFoundException, DetailsNotFoundException {
        if(checkShelterID(shelterID)){
        shelterDAO.removeShelter(shelterID);
        }
        else return;
    }
    public List<Shelter> showShelterBal() throws SQLException, ClassNotFoundException {
        return shelterDAO.showShelter();
    }

    public Shelter searchShelterByODBal(int shelterID) throws SQLException, ClassNotFoundException, DetailsNotFoundException {
        Shelter shelter=shelterDAO.searchShelterByID(shelterID);
        if(shelter==null){
            throw new DetailsNotFoundException("Shelter ID not Found");
        }
        else return shelter;
    }
}
