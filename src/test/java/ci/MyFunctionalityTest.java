
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci;


import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author thomas
 */
public class MyFunctionalityTest {
    

    public MyFunctionalityTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getTen method, of class MyFunctionality.
     */
    @Test
    public void testGetTen() {

        MyFunctionality instance = new MyFunctionality();
        assertEquals(10, instance.getTen());

    }
    
    @Test
    public void seeNames(){
        ArrayList<String> actual = DataMapper.seeAllNames();
        ArrayList<String> experted = new ArrayList<>();
         experted.add("Henning");
         experted.add("Hannah");
         experted.add("Amin");
         experted.add("Harun");
         assertEquals(experted, actual);
    }


    @Test
    public void getUserOnId(){
        User actual = DataMapper.seeUserOnUserId(2);
        User experted = new User(2,"Hannah","Dinesen","fsdkk653kk","+4540546754","Rolighedsvej 67, 2100 Kbh Ø");
        assertEquals(experted.toString(), actual.toString());
    }


    @Test
    public void updateUser(){
        int actual = DataMapper.updateUserbyUserId("+4523112334",3);
        int experted = 1;
        assertEquals(experted,actual);
    }

}
