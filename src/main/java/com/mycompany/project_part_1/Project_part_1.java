/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project_part_1;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Project_part_1 {

    public static void main(String[] args) {
          
        Logins obj = new Logins();
    Scanner input = new Scanner(System.in);
    int opt;//Stores user is option;
        //creating menu
        do {
            IO.println("\n=======Menu==========");
            IO.println("1. Sign up");
            IO.println("2. Sign in");
            IO.println("3. Exit");
            IO.println("Enter option");
            opt = input.nextInt();
            switch (opt) {
                case 1: obj.RegisterUser();
                    break;
                case 2: obj.loginUser();
                    break;
                case 3:
                    IO.println("Goodbye");
                    break;
                default:
                    IO.println("Invalid option");

            }
        }while (opt!=3 );{
            input.close();
        }
        
    }
}
