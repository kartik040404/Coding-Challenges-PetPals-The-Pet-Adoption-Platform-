package com.example.petpals;

import com.example.petpals.model.Participants;
import com.example.petpals.model.Pet;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ParticipantsTest {
    @Test
    public void testGetterAndSetter(){
        Participants participants=new Participants();
        participants.setParticipantID(1);
        participants.setParticipantName("happy shelter");
        participants.setParticipantType("shelter");
        participants.setEventID(1);
        assertEquals(1,participants.getParticipantID());
        assertEquals("happy shelter",participants.getParticipantName());
        assertEquals("shelter",participants.getParticipantType());
        assertEquals(1,participants.getEventID());
    }
    @Test
    public void testToString(){
        Participants participants=new Participants(1,"happy shelter","shelter",1);
        String result="Participants(participantID=1, participantName=happy shelter, participantType=shelter, eventID=1)\n";
        assertEquals(participants.toString()+"\n",result);
    }

    @Test
    public void testConstructor(){
        Participants participants=new Participants();
        assertNotNull(participants);
        Participants participants1=new Participants(1,"happy shelter","shelter",1);
        assertEquals(1,participants1.getParticipantID());
        assertEquals("happy shelter",participants1.getParticipantName());
        assertEquals("shelter",participants1.getParticipantType());
        assertEquals(1,participants1.getEventID());
    }
}
