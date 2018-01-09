/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.gestionPaiement.Application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sockets.gestionPaiement.GestionClient.Client;
import sockets.gestionPaiement.Publique.Server;
import sockets.gestionPaiement.Publique.ServerThread;

/**
 *
 * @author inknown
 */
public class ApplicationServer extends Server {
    
    public static void main(String[] args) throws IOException {
        ApplicationServer s=new ApplicationServer();
        s.setServerName("Application");
        s.printHeader();
        s.ChargerList();
        s.runServer(5555);
    }
    
    private ArrayList<Client> clients=new ArrayList<Client>();
    public void ChargerList(){
        clients.add(new Client(1,"koraichi","mossaab"));
        clients.add(new Client(2,"AZZA","Imane"));
        clients.add(new Client(3,"ELIDRISSI","Ayoub"));
        clients.add(new Client(4,"BOUAAZIZ","Fatima Ezzahra"));
    }
    @Override
    public void runServer(int port) {
        try {
            String msgClient,msgServer;
            serverSocket=new ServerSocket(port);
            do{
                ApplicationThread st=new ApplicationThread(acceptConnection());
                //st.setServerProduits("127.0.0.1",8888);
                st.start();
            }while(true);
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}  



































































































































































































































































































