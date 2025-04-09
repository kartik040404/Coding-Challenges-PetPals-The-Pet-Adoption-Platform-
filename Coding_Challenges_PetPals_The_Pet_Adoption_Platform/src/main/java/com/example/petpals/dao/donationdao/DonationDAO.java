package com.example.petpals.dao.donationdao;

import com.example.petpals.model.Donation;
import com.example.petpals.model.Pet;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface DonationDAO {
    void addDonation(Donation donation) throws SQLException, ClassNotFoundException;
    void removeDonation(int donationID) throws SQLException, ClassNotFoundException;
    List<Donation> showDonation() throws SQLException, ClassNotFoundException, ParseException;
}
