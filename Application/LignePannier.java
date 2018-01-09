/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.gestionPaiement.Application;

import sockets.gestionPaiement.GestionProduit.Produit;

/**
 *
 * @author inknown
 */
public class LignePannier {

    private int id;
    private Produit produit;
    private int quantité;

    public LignePannier(int id, Produit produit, int quantité) {
        this.id = id;
        this.produit = produit;
        this.quantité = quantité;
    }

    public LignePannier(Produit produit, int quantité) {
        this.produit = produit;
        this.quantité = quantité;
    }

    public LignePannier() {
    }
    public boolean equalProduit(Produit p){
        if(p.getId()==produit.getId())  return true;
        return false;
    }
    public float getTotal() {
        return produit.getPrix() * quantité;
    }
    public void ajouterQuantité(int quantité){
        this.quantité+=quantité;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the produit
     */
    public Produit getProduit() {
        return produit;
    }

    /**
     * @param produit the produit to set
     */
    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    /**
     * @return the quantité
     */
    public int getQuantité() {
        return quantité;
    }

    /**
     * @param quantité the quantité to set
     */
    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }
}
