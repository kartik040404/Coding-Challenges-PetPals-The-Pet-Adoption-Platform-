package com.example.petpals;

import com.example.petpals.model.Pet;
import com.example.petpals.model.Shelter;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ShelterTest {
    @Test
    public void testGetterAndSetter() {
        Shelter shelter = new Shelter();
        shelter.setShelterid(7);
        shelter.setName("forever home shelter");
        shelter.setLocation("404 cedar rd, downtown");
        assertEquals(7, shelter.getShelterid());
        assertEquals("forever home shelter", shelter.getName());
        assertEquals("404 cedar rd, downtown", shelter.getLocation());
    }

    @Test
    public void testToString() {
        Shelter shelter = new Shelter(7, "forever home shelter", "404 cedar rd, downtown");
        String result = "Shelter(shelterid=7, name=forever home shelter, location=404 cedar rd, downtown)\n";
        assertEquals(shelter.toString() + "\n", result);
    }

    @Test
    public void testConstructor() {
        Shelter shelter = new Shelter();
        assertNotNull(shelter);
        Shelter shelter1 = new Shelter(7, "forever home shelter", "404 cedar rd, downtown");
        assertEquals(7, shelter1.getShelterid());
        assertEquals("forever home shelter", shelter1.getName());
        assertEquals("404 cedar rd, downtown", shelter1.getLocation());
    }
}
