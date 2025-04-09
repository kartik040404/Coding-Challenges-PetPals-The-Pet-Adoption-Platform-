package com.example.petpals.bal;

import com.example.petpals.dao.adoptioneventdao.AdoptionEventDAO;
import com.example.petpals.dao.adoptioneventdao.AdoptionEventDAOImpl;
import com.example.petpals.dao.petdao.PetDAO;
import com.example.petpals.dao.petdao.PetDAOImpl;
import com.example.petpals.exception.DetailsNotFoundException;
import com.example.petpals.model.AdoptionEvent;
import com.example.petpals.model.Donation;
import com.example.petpals.model.Pet;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class AdoptionEventBal {
    static AdoptionEventDAO adoptionEventDAO;
    static {
        adoptionEventDAO=new AdoptionEventDAOImpl();
    }
    public boolean checkAdoptionEventID(int adoptionEventID) throws SQLException, ClassNotFoundException, DetailsNotFoundException, ParseException {
        if(adoptionEventDAO.searchAdoptionEventByID(adoptionEventID)==null){
            throw new DetailsNotFoundException("Event ID not Found");
        }
        else return true;
    }
    public void addPetAdoptionEventBal(AdoptionEvent adoptionEvent) throws SQLException, ClassNotFoundException {
        adoptionEventDAO.addAdoptionEvent(adoptionEvent);
    }
    public void removeAdoptionEventBal(int adoptionEventID) throws SQLException, ClassNotFoundException, DetailsNotFoundException, ParseException {
        if(checkAdoptionEventID(adoptionEventID)){
        adoptionEventDAO.removeAdoptionEvent(adoptionEventID);
        }
        else return;
    }
    public List<AdoptionEvent> showAdoptionEventBal() throws SQLException, ClassNotFoundException, ParseException {
        return adoptionEventDAO.showAdoptionEvent();
    }
    public AdoptionEvent searchAdoptionEventByODBal(int adoptionEventID) throws SQLException, ClassNotFoundException, DetailsNotFoundException, ParseException {
        AdoptionEvent adoptionEvent=adoptionEventDAO.searchAdoptionEventByID(adoptionEventID);
        if(adoptionEvent==null){
            throw new DetailsNotFoundException("Event ID not Found");
        }
        else return adoptionEvent;
    }
}
