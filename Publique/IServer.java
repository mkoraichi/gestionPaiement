/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.gestionPaiement.Publique;

import sockets.First.*;
import java.net.Socket;

/**
 *
 * @author mk
 */
public interface IServer {
    void runServer(int port);
    Socket acceptConnection();
    void envoyerBienvenue(Tunel tunel);
    String echangerMessages(Tunel tunel);
    void close(Tunel tunel);
    void printHeader();
}
