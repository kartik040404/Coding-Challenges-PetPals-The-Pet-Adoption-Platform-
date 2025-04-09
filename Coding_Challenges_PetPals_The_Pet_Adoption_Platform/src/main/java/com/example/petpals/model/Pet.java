package com.example.petpals.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pet {
    private int pedid;
    private String name;
    private int age;
    private String breed;
    private String type;
    private boolean available;
     private int shelterid;
}

