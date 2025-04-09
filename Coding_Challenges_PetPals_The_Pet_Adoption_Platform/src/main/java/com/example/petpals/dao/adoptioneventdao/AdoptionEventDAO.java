package com.example.petpals.dao.adoptioneventdao;

import com.example.petpals.model.AdoptionEvent;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface AdoptionEventDAO {
    void addAdoptionEvent(AdoptionEvent adoptionEvent) throws SQLException, ClassNotFoundException;
    void removeAdoptionEvent(int adoptionEventID) throws SQLException, ClassNotFoundException;
    List<AdoptionEvent> showAdoptionEvent() throws SQLException, ClassNotFoundException, ParseException;
}
