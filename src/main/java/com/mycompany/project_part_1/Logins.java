/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_part_1;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Student
 */
public class Logins {
    //Declaratons
        String StoreUserName ;// this variable is going to store the username used to register an account
    String StorePassword; // this variable is going to store the password cretaed during registration
    String StoreCell_NO; // this variable is going to store the cell phone number cretaed during registration
    
    Scanner UserInput = new Scanner(System.in); // declared here to be used by all methods

  public Boolean ValidUserName(String username){// mathod used to to validate the user name
    
    if (username.length()<=5 && username.contains("_")){ //checks if BOTH conditions are true
       IO.println("Username successfully captured");
        return true;

    }else {
      System.out.println("Username is not correctly formatted "+
                "Please ensure that your username contains"+
                " an underscore and is no more than five characters in length.");

      return false;
    }

  }
  public Boolean ValdPassword(String password){ // This method is used tp validate the password
  
        if (password.length() >= 8 && CheckPassword(password)) { /** Checks if the length is at least 8 characters long AND the method that checks the password if it
            contains the required criterial*/


           IO.println("The password has successfully captured.");
            return true;   // valid
        }
         else {
           IO.println("Password is not " +
                    "correctly formatted. " +
                    "please ensure that " +
                    "the password " +
                    "contains at least eight " +
                    "characters, a capital " +
                    "letter, a number, and " +
                    "a special character.");
            return false;      // invalid
        }

    }
  public boolean CheckPassword(String password){ // a method used to check the required criterials in the password
    
      int i; // for counting the length and determination of a position
    char c; // to store a specifit character in the password
    boolean hasUpper = false,hasSpecial = false,hasDegit = false; //these determines if the password have those criteria
    
    
    for ( i = 0; i < password.length(); i++){ // This loop checks every single character in the password to see if it has one of the criteria until the last charecter
      
        c = password.charAt(i) ; // stores the character at position of i;
 
        if (Character.isDigit(c)) hasDegit = true; // checks the character stored if it is a degit or not
        
      else if (Character.isUpperCase(c)) hasUpper = true; // checks the character stored if it is upper case or not
      
       else  hasSpecial = true;  // checks the character stored if it is special character or not
      }
    
    return hasUpper && hasDegit && hasSpecial; // if the condition are true then the password has been check and approved for those criteria
  }

  public boolean CheckCellPhoneNumber(String  phone_number){ //A method used to validate the cell phone number
    
    String regex ="^\\+\\d{1,3}\\d{1,10}$";/*This method validates an international phone number using a regular expression.
                                             The regex ensures the number starts with '+' followed by a country code (1–3 digits)
                                             and a maximum of 10 digits.*/
    if (Pattern.matches(regex,phone_number)){

    IO.println("Cell phone number is successfully added");
    return true;

}else {
    IO.println("Phone number is incorrectly formatted or "+
            "does nt contain international code");

    return false;
}  /*Reference:
      GeeksforGeeks, 2025. Validate Phone Numbers with Country Code using Regular Expression.
       [online] Available at: https://www.geeksforgeeks.org/dsa/validate-phone-numbers-with-country-code-extension-using-regular-expression/
        [Accessed 27 March 2026].*/
  }
    public boolean RegisterUser (){ // method used to register a user
        
        String username, password, Cell_num; 
        
        IO.println("\n=======REGISTERING========");
        
        IO.println("Enter username");
        username = UserInput.nextLine();
        
        IO.println("Enter password");
        password = UserInput.nextLine();
        
        IO.println("Enter Phone number");
        Cell_num= UserInput.nextLine();

        if (username == null || password == null || Cell_num ==null){ // checks if the user entered inputs
            
            IO.println("Enter correct details!!");
            return false;
 
        } else if (ValidUserName(username)&&ValdPassword(password) && CheckCellPhoneNumber(Cell_num)){ // otherwise if all the details are correct then stores the details

            StorePassword = password;
            StoreUserName = username;
            StoreCell_NO = Cell_num;
            
            IO.println("You have successfully registered");
            return true;

        }
        else{
            IO.println("the username,password or cell phone number does not match the criteria");// or if the method are not true then doen't register the user
            return true;
        }
    }
  public boolean loginUser(){ // method that allows a user to login
      
      String enterdUsername, enterdPassword;
      
      int attempts =3; // these are attempts that will allow a user to use
      
      boolean loginStatus = false;
      
      IO.println("\n=========Login=========");
      while (attempts >0 && !loginStatus) { // while attemps are still on and login status is false, carry on application

          IO.print("enter username:");

          enterdUsername = UserInput.nextLine();
          
          IO.print("enter password:");
          enterdPassword = UserInput.nextLine();

          if (StoreUserName.equals(enterdUsername) && StorePassword.equals(enterdPassword)) {// compares the details entered by user and the ones that were used to register

              IO.println(". Welcome " + StoreUserName +
                      ", it is great to " +
                      "see you again.");
              loginStatus = true; // and the loging status becomes true if the deatils match
          } else {
              attempts--; // if details are not match then attempts decreases
              if (attempts > 0) { //if they are still more attempts the application will allow the user to re-try
                  IO.println("Username or" +
                          "password incorrect," +
                          "please try again. " + attempts + " attempts Left"); // shows the user how many attempts are left

              }


          }

      } if (!loginStatus){ // if the user did nor able to login with given attempts then
          IO.println("Too many failed attempts. Account is locked!");
            return false;
      }else {
          return true;
      }

  }
 
}
