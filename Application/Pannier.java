/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.gestionPaiement.Application;

import java.util.ArrayList;
import jdk.nashorn.internal.objects.NativeArray;
import sockets.gestionPaiement.GestionClient.Client;
import sockets.gestionPaiement.GestionProduit.Produit;

/**
 *
 * @author inknown
 */
public class Pannier {

    int id;
    Client client;
    ArrayList<LignePannier> lignes = new ArrayList<LignePannier>();

    public double getTotal() {
        double result = 0;
        for (LignePannier l : lignes) {
            result += l.getTotal();
        }
        return result;
    }

    public void ajouter(Produit p, int quantité) {
        boolean tr = false;
        for (LignePannier l : lignes) {
            if (l.equalProduit(p)) {
                tr = true;
                l.ajouterQuantité(quantité);
            }
        }
        if (!tr) {
            lignes.add(new LignePannier(p, quantité));
        }
    }

}
