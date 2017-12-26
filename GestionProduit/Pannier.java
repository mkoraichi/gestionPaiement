/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.gestionPaiement.GestionProduit;

import java.util.ArrayList;
import jdk.nashorn.internal.objects.NativeArray;
import sockets.gestionPaiement.GestionClient.Client;

/**
 *
 * @author inknown
 */
public class Pannier {
    int id;
    Client client;
    ArrayList<LignePannier> lignes=new ArrayList<LignePannier>();
    
    public void ajouter(Produit p,int quantité){
        boolean tr=false;
        for(LignePannier l : lignes){
            if(l.equalProduit(p)){
                tr=true;
                l.ajouterQuantité(quantité);
            }
        }
        if(!tr) lignes.add(new LignePannier(p, quantité));
    }
    
}
