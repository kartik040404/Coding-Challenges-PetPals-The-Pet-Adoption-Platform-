package com.example.petpals.model;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdoptionEvent {
    private int eventID;
    private String eventName;
    private Date eventDate;
    private String location;
}
