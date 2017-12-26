/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.gestionPaiement.GestionBanque;

import sockets.First.Client;

/**
 *
 * @author inknown
 */
public class Compte {
    private int id;
    private float montant;
    private Client client;

    public Compte() {
    }

    public Compte(int id, float montant, Client client) {
        this.id = id;
        this.montant = montant;
        this.client = client;
    }
    public Compte(int id, float montant) {
        this.id = id;
        this.montant = montant;
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
     * @return the montant
     */
    public float getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    public void setMontant(float montant) {
        this.montant = montant;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }
}
