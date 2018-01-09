/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.gestionPaiement.Publique;

import sockets.First.*;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mk
 */
public class ServerThread extends Thread implements Runnable {

    protected Tunel tunel;
    protected String bienvenueMessage = "bienvenu";
    protected String arretMessage = "bye";
    protected String msgClient,msgServer;
    protected Scanner scaner = new Scanner(System.in);
    public ServerThread() {
    }

    public ServerThread(Socket socket) {
        this.tunel = new Tunel(socket);
    }

    public ServerThread(Socket socket, String bienvenueMessage, String arretMessage) {
        this.tunel = new Tunel(socket);
        this.bienvenueMessage = bienvenueMessage;
        this.arretMessage = arretMessage;
    }

    public void envoyerBienvenue(Tunel tunel) {
        try {
            tunel.send(getBienvenueMessage());
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close(Tunel tunel) {
        try {
            tunel.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
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
}
