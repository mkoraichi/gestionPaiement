/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionPaiement;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author mk
 */
public class Client {
    
    public static void main(String[] args) throws UnknownHostException, IOException {
   
        System.out.println("----------Client--------");
        String msg,arreteMessage="bye";
        Scanner scaner=new Scanner(System.in);
        Tunel tunel=new Tunel("127.0.0.1",1234);
        do{
            System.out.println("attend!!");
            msg=tunel.readChat();
            System.out.println(msg);
            System.out.print("vous : ");
            msg=scaner.nextLine();
            tunel.sendChat(msg);
            
        }while(!msg.equals(arreteMessage));
        
    
    
    }
}
