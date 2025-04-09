package com.example.petpals;

import com.example.petpals.model.Pet;
import org.junit.Test;

import static org.junit.Assert.*;

public class PetTest {
    @Test
    public void testGetterAndSetter(){
        Pet pet=new Pet();
        pet.setPedid(1);
        pet.setName("Buddy");
        pet.setAge(5);
        pet.setType("Dog");
        pet.setBreed("Golden Retriever");
        pet.setAvailable(true);
        pet.setShelterid(1);
        assertEquals(1,pet.getPedid());
        assertEquals("Buddy",pet.getName());
        assertEquals(5,pet.getAge());
        assertEquals("Dog",pet.getType());
        assertEquals("Golden Retriever",pet.getBreed());
        assertTrue(pet.isAvailable());
        assertEquals(1,pet.getShelterid());
    }
//Pet(pedid=1, name=buddy, age=3, breed=golden retriever, type=dog, available=true, shelterid=0)
    @Test
    public void testToString(){
        Pet pet=new Pet(1,"Buddy",5,"Golden Retriever","Dog",true,1);
        String result="Pet(pedid=1, name=Buddy, age=5, breed=Golden Retriever, type=Dog, available=true, shelterid=1)\n";
        assertEquals(pet.toString()+"\n",result);
    }

    @Test
    public void testConstructor(){
        Pet pet=new Pet();
        assertNotNull(pet);
        Pet pet1=new Pet(1,"Buddy",5,"Golden Retriever","Dog",true,1);
        assertEquals(1,pet1.getPedid());
        assertEquals("Buddy",pet1.getName());
        assertEquals(5,pet1.getAge());
        assertEquals("Dog",pet1.getType());
        assertEquals("Golden Retriever",pet1.getBreed());
        assertTrue(pet1.isAvailable());
        assertEquals(1,pet1.getShelterid());
    }
}
