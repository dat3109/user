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
public class user {
   private String userName,passWord,Fname, Lname, phoneNumber, Email, birthDay ; 

    public user() {
    }

    @Override
    public String toString() {
        return userName + "," + passWord + "," + Fname + "," + Lname + "," + birthDay + ","+ phoneNumber + "," + Email   ;
    }

    public user(String userName, String passWord, String Fname, String Lname, String phoneNumber, String Email) {
        this.userName = userName;
        this.passWord = passWord;
        this.Fname = Fname;
        this.Lname = Lname;
        this.phoneNumber = phoneNumber;
        this.Email = Email;
        this.birthDay = birthDay;
    }

    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
    
    
}
