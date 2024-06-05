/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

import java.util.Scanner;

/**
 *dw
 * @author Admin
 */
public class main {
    public static void main(String[] args) {
        util userName = new util();
        String choice = "-1";
        userName.readingFromFile();      
       while(!choice.equals("0")){
        userName.menu();
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter your choice(0-6): ");   
        choice = sc.nextLine();
        
        //userName.PrintAllUserNameExisted();
        switch(choice){
            case "1": 
            userName.createAccount();
            userName.fileSaving(); 
            break;
            case "2":
            userName.checkExistUser();
            break;
            case "3":
            userName.searchUserInfomationByName();
            break;
            case "4":
            userName.deleteUser();
            userName.fileSaving(); 
            break;
            case "5":
            userName.PrintAllUserNameExisted();
            break;
            case "6":
            userName.PrintAllUserInfomation();
            break;
            case "0":
                System.out.println("Exit");
                break;
            default:
                System.out.println("Your choice is error.");
                break;
       }      
      
        }
    }
}
