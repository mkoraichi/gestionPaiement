/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.gestionPaiement.Application;

import java.io.IOException;
import java.rmi.server.Operation;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sockets.gestionPaiement.GestionProduit.Pannier;
import sockets.gestionPaiement.GestionProduit.Produit;
import sockets.gestionPaiement.Publique.Operations;
import sockets.gestionPaiement.Publique.ServerThread;

/**
 *
 * @author inknown
 */
public class ApplicationThread extends ServerThread {

    /**
     *
     */
    protected Pannier pannier = new Pannier();

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
            int clientId = tunel.readInt();

        } catch (IOException ex) {
            Logger.getLogger(ApplicationThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
