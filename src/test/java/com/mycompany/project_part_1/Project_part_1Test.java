/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.project_part_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class Project_part_1Test {
    
   Logins obj = new Logins();

    @Test
    void TestUsername(){
        String Username = "kyl_u";
       boolean results = obj.ValidUserName(Username);

        Assertions.assertEquals(true ,results);
    }
    @Test
    void TestWrongUsername(){
        String Username = "kyle!!!!!!!!";
        boolean results = obj.ValidUserName(Username);

        Assertions.assertEquals(false ,results);
    }
    @Test
    void TestValidPassword(){
        String password ="Ch&&sec@ke99!";
        boolean results = obj.ValdPassword(password);

        Assertions.assertEquals(true ,results);
    }
    @Test
    void TestUnvalidPassword(){
        String password ="password";
        boolean results = obj.ValdPassword(password);

        Assertions.assertEquals(false ,results);
    }
    @Test
    void TestValidCell_NO(){
        String phoneNumber ="+27838968978";
        boolean results = obj.CheckCellPhoneNumber(phoneNumber);

        Assertions.assertEquals(true ,results);
    }
    @Test
    void TestInvalidCell_NO(){
        String phoneNumber ="08966553";
        boolean results = obj.CheckCellPhoneNumber(phoneNumber);

        Assertions.assertEquals(false ,results);

    }
    


    
}
