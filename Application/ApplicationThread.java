/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.gestionPaiement.Application;

import java.io.IOException;
import java.net.Socket;
import java.rmi.server.Operation;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sockets.gestionPaiement.GestionClient.Client;
import sockets.gestionPaiement.GestionProduit.Produit;
import sockets.gestionPaiement.Publique.Operations;
import sockets.gestionPaiement.Publique.ServerThread;
import sockets.gestionPaiement.Publique.Tunel;

/**
 *
 * @author inknown
 */
public class ApplicationThread extends ServerThread {

    /**
     *
     */
    protected Pannier pannier = new Pannier();
    private Tunel serverProduits=null;
    Client client=null;
    public ApplicationThread(Socket socket) {
        super(socket);
    }

    public ApplicationThread(Socket socket, String bienvenueMessage, String arretMessage) {
      super(socket,bienvenueMessage,arretMessage);
    }
    public void ajouterProduit(Produit p, int quantité) {
        pannier.ajouter(p, quantité);
    }

    public double getTotal() {
        return pannier.getTotal();
    }

    @Override
    public void run() {
        try {
                tunel.send(Operations.DemandeId.toString());
                int id = tunel.readInt();
                tunel.send(Operations.DemandeNom.toString());
                String nom = tunel.read();
                tunel.send(Operations.DemandePrenom.toString());
                String prenom = tunel.read();
                client=new Client(id,nom,prenom);
                tunel.send(Operations.Libre.toString());
            do{
               msgClient=tunel.read();
               if(msgClient.equals(Operations.Ajouter.toString())){
                   tunel.send(Operations.DemandeIdProduit.toString());
                   id=tunel.readInt();
                   tunel.send(Operations.DemandeQteProduit.toString());
                   int qte=tunel.readInt();
                   Produit p=getProduit(id);
                   pannier.ajouter(p, qte);
               }
               else if(msgClient.equals(Operations.Calculer.toString())){
                   tunel.send(Double.toString(getTotal()));
               }
               else if(msgClient.equals(Operations.Payer.toString())){
                   
                tunel.send(Operations.Libre.toString());
               }
            }while(msgClient.equals(arretMessage));

        } catch (IOException ex) {
            Logger.getLogger(ApplicationThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @return the serverProduits
     */
    public Tunel getServerProduits() {
        return serverProduits;
    }

    /**
     * @param serverProduits the serverProduits to set
     */
    public void setServerProduits(Socket serverProduits) {
        this.serverProduits = new Tunel(serverProduits);
    }
        public void setServerProduits(String host,int port) {
        try {
            this.serverProduits = new Tunel(host,port);
        } catch (IOException ex) {
            Logger.getLogger(ApplicationThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Produit getProduit(int id){
        Produit p=null;
        try {
            serverProduits.send(Operations.DemandeProduit.toString());
            p=new Produit(serverProduits.readInt(), serverProduits.readFloat());
        } catch (IOException ex) {
            Logger.getLogger(ApplicationThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
}
