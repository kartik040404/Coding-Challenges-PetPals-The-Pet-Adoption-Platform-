package com.example.petpals;

import com.example.petpals.model.Donation;
import com.example.petpals.model.Pet;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DonationTest {
    static SimpleDateFormat simpleDateFormat;
    static {
        simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    @Test
    public void testGetterAndSetter() throws ParseException {
        Donation donation=new Donation();
       donation.setDonationid(1);
       donation.setDonorname("john doe");
       donation.setDonationtype("cash");
       donation.setDonationamount(100.0);
       donation.setDonationitem(null);
       donation.setDonationdate(simpleDateFormat.parse("2024-03-01 10:00:00"));
       assertEquals(1,donation.getDonationid());
       assertEquals("john doe",donation.getDonorname());
       assertEquals("cash",donation.getDonationtype());
       assertEquals(100.0,donation.getDonationamount(),2);
       assertEquals(null,donation.getDonationitem());
       assertEquals("2024-03-01 10:00:00",simpleDateFormat.format(donation.getDonationdate()));
    }
    @Test
    public void testToString() throws ParseException {
        Donation donation=new Donation(1,"john doe","cash",100.0,null,simpleDateFormat.parse("2024-03-01 10:00:00"));
        String result="Donation(donationid=1, donorname=john doe, donationtype=cash, donationamount=100.0, donationitem=null, donationdate=Fri Mar 01 10:00:00 IST 2024)\n";
        assertEquals(donation.toString()+"\n",result);
    }

    @Test
    public void testConstructor() throws ParseException {
        Donation donation=new Donation();
        assertNotNull(donation);
        Donation donation1=new Donation(1,"john doe","cash",100.0,null,simpleDateFormat.parse("2024-03-01 10:00:00"));
        donation1.setDonationid(1);
        donation1.setDonorname("john doe");
        donation1.setDonationtype("cash");
        donation1.setDonationamount(100.0);
        donation1.setDonationitem(null);
        donation1.setDonationdate(simpleDateFormat.parse("2024-03-01 10:00:00"));
    }
}
