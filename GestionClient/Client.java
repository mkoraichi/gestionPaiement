/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.gestionPaiement.GestionClient;

import java.awt.Desktop;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sockets.gestionPaiement.Publique.Operations;
import sockets.gestionPaiement.Publique.Tunel;

/**
 *
 * @author inknown
 */
public class Client {
    public static void main(String[] args) {
        Client c=new Client();
        c.connecter("127.0.0.1", 5555);
        c.run();
            
            
    }
   
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String cin;
    private String login;
    private String password;
    private Tunel tunel=null;
    protected String bienvenueMessage="bienvenu";
    protected String arretMessage="bye";
    protected Scanner keyboard=new Scanner(System.in);
    
    public void connecter(String address,int port){
        try {
            this.tunel=new Tunel(address,port);
            System.out.println(tunel.read());
            tunel.send(Integer.toString(this.id));
            System.out.println(tunel.read());
            tunel.send(this.nom);
            System.out.println(tunel.read());
            tunel.send(this.prenom);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void connecter(InetAddress address,int port){
        try {
            this.tunel=new Tunel(address,port);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Client() {
        System.out.println("Donner ID : ");
        this.id=keyboard.nextInt();
        System.out.println("Donner le nom : ");
        this.nom = keyboard.nextLine();
        this.nom = keyboard.nextLine();
        System.out.println("Donner le prenom : ");
        this.prenom = keyboard.nextLine();
    }
    public Client(int id,String nom, String prenom) {
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
    }
    public Client(String nom, String prenom, String adresse, String cin, String login, String password) {
        this.id=0;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.cin = cin;
        this.login = login;
        this.password = password;
    }
    
    public Client(int id, String nom, String prenom, String adresse, String cin, String login, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.cin = cin;
        this.login = login;
        this.password = password;
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
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the cin
     */
    public String getCin() {
        return cin;
    }

    /**
     * @param cin the cin to set
     */
    public void setCin(String cin) {
        this.cin = cin;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    public void run(){
        int choix=0;
        do{
            choix=Menu();
        }while(choix<4);
    }
    public int Menu(){
            int choix=0;
        try {
            do{
                System.out.println(String.format("\n--------Menu--------\n >1 - %s\n >2 - %s\n >3 - %s\n >4 - Quiter\n", Operations.Ajouter.toString()
                        , Operations.Calculer.toString()
                        , Operations.Payer.toString()));
                choix=keyboard.nextInt();
            }while(choix<1 && choix>4);
            switch(choix){
                case 1:
                    tunel.send(Operations.Ajouter.toString());
                    ajouterProduit(id, id)
                    break;
                case 2:
                    tunel.send(Operations.Calculer.toString());
                    break;
                    
                case 3:
                    tunel.send(Operations.Payer.toString());
                    break;
                    
                case 4:
                    tunel.send(arretMessage);
                    break;
                    
            }} catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return choix;
    }
    public void ajouterProduit(int id,int qte){
        try {
            tunel.read();
            tunel.send(Integer.toString(id));
            tunel.read();
            tunel.send(Integer.toString(qte));
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
