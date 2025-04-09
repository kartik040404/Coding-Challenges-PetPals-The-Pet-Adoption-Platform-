package com.example.petpals.bal;

import com.example.petpals.dao.donationdao.DonationDAO;
import com.example.petpals.dao.donationdao.DonationDAOImpl;
import com.example.petpals.dao.petdao.PetDAO;
import com.example.petpals.dao.petdao.PetDAOImpl;
import com.example.petpals.exception.DetailsNotFoundException;
import com.example.petpals.exception.InsufficientFundsException;
import com.example.petpals.model.Donation;
import com.example.petpals.model.Pet;
import com.example.petpals.model.Shelter;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class DonationBal {
    static DonationDAO donationDAO;
    static {
        donationDAO=new DonationDAOImpl();
    }
    public boolean checkDonationID(int donationID) throws SQLException, ClassNotFoundException, DetailsNotFoundException, ParseException {
        if(donationDAO.searchDonationByID(donationID)==null){
            throw new DetailsNotFoundException("Donation Details not Found");
        }
        else return true;
    }
    public void addDonationBal(Donation donation) throws SQLException, ClassNotFoundException {
        donationDAO.addDonation(donation);
    }
    public void removeDonationBal(int donationID) throws SQLException, ClassNotFoundException, DetailsNotFoundException, ParseException {
        if(checkDonationID(donationID)){
        donationDAO.removeDonation(donationID);
        }
        else return;
    }
    public List<Donation> showDonationBal() throws SQLException, ClassNotFoundException, ParseException {
        return donationDAO.showDonation();
}
    public Donation searchDonationByODBal(int donationID) throws SQLException, ClassNotFoundException, DetailsNotFoundException, ParseException {
        Donation donation=donationDAO.searchDonationByID(donationID);
        if(donation==null){
            throw new DetailsNotFoundException("Donation ID not Found");
        }
        else return donation;
    }
    public boolean checkAmount(double amount) throws InsufficientFundsException {
        if(amount<10){
            throw new InsufficientFundsException("Insufficient Amount");
        }
        return true;
    }

}
