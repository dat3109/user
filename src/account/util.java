/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class util {
    ArrayList<user> userList = new ArrayList();

    public void createAccount() {
        Scanner sc = new Scanner(System.in);
        user user = new user();
     System.out.print("Enter User Name (At least 5 characters, do not have space character and first character is not a number):");
     String userName = sc.nextLine();
     boolean duplicate = true;
   while (!userName.matches("^[a-zA-Z][a-zA-Z0-9]+{4,}") || duplicate == true){
         duplicate=false;
         for(user user1: userList){
             if (userName.equals(user1.getUserName())){
                  System.out.print("This user is already existed. Re-Enter your user: ");
                   userName = sc.nextLine();
                   duplicate = true;
             }}
         if(!userName.matches("^[a-zA-Z][a-zA-Z0-9]{4,}")){{
             System.out.print("Re-Enter User Name (At least 5 characters, do not have space character and first character is not a number):");}
         userName = sc.nextLine();
          
             
         }
     }
      user.setUserName(userName);
     System.out.print("Enter your password (At least 6 characters and do not have space character): ");
     String passWord = sc.nextLine();
     while (!passWord.matches("[0-9A-Za-z]{6,}+"))
     {  System.out.print("Re-Enter pass word (At least 6 characters and do not have space character): ");
        passWord = sc.nextLine();
     }
     user.setPassWord(passWord);
     
     System.out.print("Enter your first name( Do not have number and space chacracter):");
     String Fname = sc.nextLine();
     while(!Fname.matches("[a-zA-Z]+")){
     System.out.print("Re-Enter First name( Do not have number and space chacracter): ");
       Fname = sc.nextLine();
     }
     user.setFname(Fname);

     System.out.print("Enter your last name( Do not have number and space chacracter):");
     String Lname = sc.nextLine();
     while(!Lname.matches("[a-zA-Z]+")){
     System.out.print("Re-Enter First name( Do not have number and space chacracter): ");
       Lname = sc.nextLine();
     }
     user.setLname(Lname);
        

        System.out.print("Enter your date of birth( dd/mm/yyyy): ");
        String birthDay = sc.nextLine();
        while(!birthDay.matches("[0-9]{2,2}[/][0-9]{2,2}[/][0-9]{4,4}")){
            System.out.print("Re-Enter your date of birth( dd/mm/yyyy): ");
            birthDay = sc.nextLine();
        }
        user.setBirthDay(birthDay);
        
        System.out.print("Enter your email(YourEmail@__.__): ");
        String Email = sc.nextLine();
        while (!Email.matches("[a-zA-Z0-9]+[@][a-z]+[.][a-z]+")) {
            System.out.print("Re-Enter your email(YourEmail@__.__): ");
            
            Email = sc.nextLine();
        }
        user.setEmail(Email);
        
        System.out.print("Enter your phone number(First number is 0 and must have 10 numbers):");
        String PhoneNumber = sc.nextLine();
        while(!PhoneNumber.matches("^[0][0-9]{9,9}")){
            System.out.print("Re-Enter your phone number(First number is 0 and must have 10 numbers): ");
            PhoneNumber = sc.nextLine();
        }
        user.setPhoneNumber(PhoneNumber);
        userList.add(user);

    }
    public void fileSaving() {
        try {
//             File file = new File("User.dat");
//             file.deleteOnExit();
            FileWriter input = new FileWriter("User.dat");
            PrintWriter write = new PrintWriter(input);
             
             for ( user user : userList) {
                write.println(user);
            }
             
            write.close();
            input.close();
        } catch (Exception e) {
           System.out.println("");
        }
    }
    public void readingFromFile() {
        try {
            FileReader output = new FileReader("User.dat");
            BufferedReader read = new BufferedReader(output);
            ArrayList<user> temporaryList = new ArrayList();
            String line;
            while ((line = read.readLine()) != null) {

                String[] dataSplit = line.split(",");
                user user = new user();
                user.setUserName(dataSplit[0]);
                user.setPassWord(dataSplit[1]);
                user.setFname(dataSplit[2]);
                user.setLname(dataSplit[3]);
                user.setBirthDay(dataSplit[4]);
                user.setPhoneNumber(dataSplit[5]);
                user.setEmail(dataSplit[6]);
                temporaryList.add(user);
            }
            userList.addAll(temporaryList);
            read.close();
            output.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }
    
    public void checkExistUser() {
        Scanner sc = new Scanner(System.in);
        user user = new user();
        System.out.print("Enter User Name to check:");
        String userName = sc.nextLine(); 
        int a,b;
        a=0; b=0;
        for(user user1: userList){
            a+=1;
             if (userName.equals(user1.getUserName())){
                  System.out.println("This user is already existed."); 
                  break;
    }
             else{
                 b+=1;
             }
}
             if (b==a){
             System.out.print("This user is not existed.");
         }
    }
    public void searchUserInfomationByName(){
     Scanner sc = new Scanner(System.in);
        System.out.print("Enter usernname to check infomation:");
        String userName = sc.nextLine();
        int a,b;
         a=0; b=0;
         for (user user : userList) {
             a+=1;
            if(userName.equals(user.getUserName())) {
                System.out.println("User found.");
                System.out.println("User name: " + user.getUserName());
                System.out.println("Password: " + user.getPassWord());
                System.out.println("First name: " + user.getFname());
                System.out.println("Last name: " + user.getLname());
                System.out.println("Date of birth: " + user.getBirthDay());
                System.out.println("Phone Number: " + user.getPhoneNumber());
                break;
            }
            else{b+=1;}
        }
         if (b==a){
             System.out.println("User can not found with this name.");
         }
    
    }
 public void deleteUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter user name to delete: ");
        String userName = sc.nextLine();
        
        Iterator<user> iterator = userList.iterator();
        boolean userFound = false;
        
        while (iterator.hasNext()) {
            user user = iterator.next();
            if (userName.equals(user.getUserName())) {
                iterator.remove();
                System.out.println("User " + userName + " has been removed.");
                userFound = true;
                break;
            }
        }

        if (!userFound) {
            System.out.println("User " + userName + " not found.");
        }
    }
 public void menu(){
     System.out.println("----Menu---");
     System.out.println("1. Create new account.");
     System.out.println("2. Check existed user.");
     System.out.println("3. Search user infomation by user name.");
     System.out.println("4. Delete user by user name.");
     System.out.println("5. Show all user name.");
     System.out.println("6. Show all user infomation.");
     System.out.println("0. Exit.");
 }
 public void PrintAllUserNameExisted(){
     int i = 0;
   for (user user : userList){
       i+=1;
       System.out.println("User Name "+i+" is "+user.getUserName());
   }
   if(i==0)
   {System.out.println("Can not found any user name existed.");}
 }
 
 public void PrintAllUserInfomation(){  
      int i=1;
         for (user user : userList) {  
                
                 System.out.println("User Name "+i);
                System.out.println("User name: " + user.getUserName());
                System.out.println("Password: " + user.getPassWord());
                System.out.println("First name: " + user.getFname());
                System.out.println("Last name: " + user.getLname());
                System.out.println("Date of birth: " + user.getBirthDay());
                System.out.println("Phone Number: " + user.getPhoneNumber());
                i+=1;  
         }
         if (userList == null || userList.isEmpty()) {
     System.out.println("Can not found any user name existed.");
     return;
}
    
   }
 }

    

