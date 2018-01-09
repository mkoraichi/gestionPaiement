/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.gestionPaiement.Publique;

import sockets.First.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mk
 */
public class Server implements IServer{

    
    protected ServerSocket serverSocket;
    protected String bienvenueMessage="bienvenu";
    protected String arretMessage="bye";
    private String serverName="Default";
    protected Scanner keyboard=new Scanner(System.in);
    @Override
    public Socket acceptConnection() {
        try {
            return serverSocket.accept();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public void printHeader(){
        System.out.println("------------"+getServerName()+"---------------");
    }
    @Override
    public void envoyerBienvenue(Tunel tunel) {
        try {
            tunel.send(getBienvenueMessage());
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String echangerMessages(Tunel tunel) {
        try {
            System.out.println("attend!!");
            String clientMsg=tunel.read();
            System.out.println(tunel.addChatInfos(clientMsg));
            System.out.print("vous : ");
            String mymsg=keyboard.nextLine();
            tunel.sendChat(mymsg);
            return clientMsg;
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void close(Tunel tunel) {
        try {
            tunel.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void runServer(int port) {
        try {
            
            serverSocket=new ServerSocket(port);
            do{
                ServerThread st=new ServerThread(acceptConnection());
                st.start();
            }while(true);
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the bienvenueMessage
     */
    public String getBienvenueMessage() {
        return bienvenueMessage;
    }

    /**
     * @param bienvenueMessage the bienvenueMessage to set
     */
    public void setBienvenueMessage(String bienvenueMessage) {
        this.bienvenueMessage = bienvenueMessage;
    }

    /**
     * @return the arretMessage
     */
    public String getArretMessage() {
        return arretMessage;
    }

    /**
     * @param arretMessage the arretMessage to set
     */
    public void setArretMessage(String arretMessage) {
        this.arretMessage = arretMessage;
    }

    /**
     * @return the serverName
     */
    public String getServerName() {
        return serverName;
    }

    /**
     * @param serverName the serverName to set
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
}
