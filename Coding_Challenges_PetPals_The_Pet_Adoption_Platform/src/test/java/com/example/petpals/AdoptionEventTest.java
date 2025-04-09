package com.example.petpals;

import com.example.petpals.model.AdoptionEvent;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AdoptionEventTest {
    static SimpleDateFormat simpleDateFormat;
    static {
        simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    @Test
    public void testGetterAndSetter() throws ParseException {
        AdoptionEvent adoptionEvent=new AdoptionEvent();
        adoptionEvent.setEventID(1);
        adoptionEvent.setEventName("spring adoption fair");
        adoptionEvent.setEventDate(simpleDateFormat.parse("2024-03-15 10:00:00"));
        adoptionEvent.setLocation("central park");
        assertEquals(1,adoptionEvent.getEventID());
        assertEquals("spring adoption fair",adoptionEvent.getEventName());
        assertEquals("2024-03-15 10:00:00",simpleDateFormat.format(adoptionEvent.getEventDate()));
        assertEquals("central park",adoptionEvent.getLocation());
    }
    @Test
    public void testToString() throws ParseException {
        AdoptionEvent event=new AdoptionEvent(1,"spring adoption fair",simpleDateFormat.parse("2024-03-15 10:00:00"),"central park");
        String result="AdoptionEvent(eventID=1, eventName=spring adoption fair, eventDate=Fri Mar 15 10:00:00 IST 2024, location=central park)\n";
        assertEquals(event.toString()+"\n",result);
    }

    @Test
    public void testConstructor() throws ParseException {
        AdoptionEvent adoptionEvent=new AdoptionEvent();
        assertNotNull(adoptionEvent);
        AdoptionEvent event=new AdoptionEvent(1,"spring adoption fair",simpleDateFormat.parse("2024-03-15 10:00:00"),"central park");
        assertEquals(1,event.getEventID());
        assertEquals("spring adoption fair",event.getEventName());
        assertEquals("2024-03-15 10:00:00",simpleDateFormat.format(event.getEventDate()));
        assertEquals("central park",event.getLocation());
    }
}
