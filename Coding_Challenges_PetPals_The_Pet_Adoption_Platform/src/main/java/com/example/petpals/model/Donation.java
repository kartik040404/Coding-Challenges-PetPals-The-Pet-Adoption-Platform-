package com.example.petpals.model;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Donation {
    private int donationid;
    private String donorname;
    private String donationtype;
    private double donationamount;
    private String donationitem;
    private Date donationdate;
}
