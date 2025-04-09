package com.example.petpals.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Participants {
    private int participantID;
    private String participantName;
    private String participantType;
    private int eventID;
}
