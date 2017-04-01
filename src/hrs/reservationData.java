/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs;

/**
 *
 * @author Im_jay
 */
import java.util.*;

public class reservationData {
    Date CheckIn;
    Date CheckOut;
    int Days;
    String NumberOfGuest;
    String NumberOfRoom;
    
    public reservationData(){}
    public reservationData(Date d1, Date d2,int n, String str1, String str2){
        CheckIn = d1;
        CheckOut=d2;
        Days = n;
        NumberOfGuest=str1;
        NumberOfRoom=str2;
    }
    
    public Date checkIn(){
        return CheckIn;
    }
    
    public Date checkOut(){
        return CheckOut;
    }
    public int days(){
        return Days;
    }
    public String numberOfGuest(){
        return NumberOfGuest;
    }
    public String numberOfRoom(){
        return NumberOfRoom;
    }
}
