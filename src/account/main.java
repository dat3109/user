/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

/**
 *
 * @author Admin
 */
public class main {
    public static void main(String[] args) {
        util userName = new util();
        userName.readingFromFile();
       // userName.checkExistUser();
     //   userName.createAccount();  
       userName.fileSaving();
        userName.searchUserInfomationByName();
    }
}
