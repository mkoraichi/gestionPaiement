/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.gestionPaiement.Application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sockets.gestionPaiement.GestionProduit.Pannier;
import sockets.gestionPaiement.GestionProduit.Produit;
import sockets.gestionPaiement.Publique.ServerThread;

/**
 *
 * @author inknown
 */
public class ApplicationThread extends ServerThread{

    /**
     *
     */
    protected Pannier pannier=new Pannier();
    
    public void ajouterProduit(Produit p,int quantité){
        
    }
        public void getTotal(){
        double result=0;
        for(LignePannier)
    }
    @Override
    public void run() {
        try {
            tunel.send("Envoyer Votre données :");
            String msgClient=tunel.read();
            
        } catch (IOException ex) {
            Logger.getLogger(ApplicationThread.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
