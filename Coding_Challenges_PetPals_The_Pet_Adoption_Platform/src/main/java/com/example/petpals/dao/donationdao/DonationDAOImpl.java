package com.example.petpals.dao.donationdao;

import com.example.petpals.model.Donation;
import com.example.petpals.model.Pet;
import com.example.petpals.model.Shelter;
import com.example.petpals.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DonationDAOImpl implements DonationDAO{
    static Connection connection;
    static PreparedStatement preparedStatement;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void addDonation(Donation donation) throws SQLException, ClassNotFoundException {
        connection= ConnectionHelper.getConnection();
        String stmt="Insert into donations (donorname,donationtype,donationamount,donationitem,donationdate) values(?,?,?,?,?)";
        preparedStatement=connection.prepareStatement(stmt);
        preparedStatement.setString(1,donation.getDonorname());
        preparedStatement.setString(2,donation.getDonationtype());
        preparedStatement.setDouble(3,donation.getDonationamount());
        preparedStatement.setString(4,donation.getDonationitem());
        preparedStatement.setString(5,sdf.format(donation.getDonationdate()));
        int rowsInserted=preparedStatement.executeUpdate();
        if(rowsInserted>0){
            System.out.println("Donation Details inserted successfully");
        }
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void removeDonation(int donationID) throws SQLException, ClassNotFoundException {
        String stmt="Delete from donations where donationid=?";
        connection=ConnectionHelper.getConnection();
        preparedStatement=connection.prepareStatement(stmt);
        preparedStatement.setInt(1,donationID);
        int rowsDeleted=preparedStatement.executeUpdate();
        if(rowsDeleted>0){
            System.out.println("Donation details deleted successfully");
        }
        connection.close();
        preparedStatement.close();
    }

    @Override
    public List<Donation> showDonation() throws SQLException, ClassNotFoundException, ParseException {
        connection=ConnectionHelper.getConnection();
        String stmt="Select * from donations";
        preparedStatement=connection.prepareStatement(stmt);
        ResultSet resultSet=preparedStatement.executeQuery();
        List<Donation> donationList=new ArrayList<>();
        Donation donation=null;
        while (resultSet.next()){
            donation=new Donation();
            donation.setDonationid(resultSet.getInt("donationid"));
            donation.setDonorname(resultSet.getString("donorname"));
            donation.setDonationtype(resultSet.getString("donationtype"));
            donation.setDonationamount(resultSet.getDouble("donationamount"));
            donation.setDonationitem(resultSet.getString("donationitem"));

            donation.setDonationdate(sdf.parse(resultSet.getString("donationdate")));
            donationList.add(donation);
        }
        connection.close();
        preparedStatement.close();
        return donationList;
    }

    @Override
    public Donation searchDonationByID(int donationID) throws SQLException, ClassNotFoundException {
        connection=ConnectionHelper.getConnection();
        String stmt="Select * from donations where donationid=?";
        preparedStatement=connection.prepareStatement(stmt);
        preparedStatement.setInt(1,donationID);
        ResultSet resultSet=preparedStatement.executeQuery();
        Donation donation=null;
        if(resultSet.next()){
            donation=new Donation();
            donation.setDonationid(resultSet.getInt("donationid"));
            donation.setDonorname(resultSet.getString("donorname"));
            donation.setDonationtype(resultSet.getString("donationtype"));
            donation.setDonationamount(resultSet.getDouble("donationamount"));
            donation.setDonationitem(resultSet.getString("donationitem"));
        }
        connection.close();
        preparedStatement.close();
        return donation;
    }
}
