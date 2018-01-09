/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.gestionPaiement.Publique;

import sockets.First.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import projetRestaurant.Classes.Ingrediant;

/**
 *
 * @author mk
 */
public class Tunel {
    Socket socket;
    PrintWriter out;
    BufferedReader in;
    protected Scanner keyboard=new Scanner(System.in);
    public Tunel(String adr, int port) throws IOException {
        this.socket = new Socket(adr, port);
    };
    public boolean isConnected(){
        return this.socket.isConnected();
    }
    public boolean isBound(){
        return this.socket.isBound();
    }
    public Tunel(InetAddress adr, int port) throws IOException {
        this.socket = new Socket(adr, port);
    }
    public Tunel(Socket socket) {
        this.socket = socket;
    }
    public void send(String message) throws IOException{
            out=new PrintWriter(socket.getOutputStream());
            out.println(message);
            out.flush();
    }
    public void sendChat(String message) throws IOException{
        System.out.println("> vous : "+message);
            send(message);
    }
    public String exChange(String message) throws IOException{
        send(message);
        return read();
    }
    public void sendKeyboard() throws IOException{
        send(keyboard.nextLine());
    }
    public String read() throws IOException{
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            return in.readLine();
    }
    
    public int readInt() throws IOException{
            return new Integer(read());
    }
    public float readFloat() throws IOException{
            return new Float(read());
    }
    public String readChat() throws IOException{
           String msg=String.format("> %s:%s : %s",socket.getInetAddress().getHostName() ,socket.getPort(),read());
            return msg;
    }
    public String addChatInfos(String message){
           return String.format("> %s:%s : %s",socket.getInetAddress().getHostName() ,socket.getPort(),message);
    }
    public void close() throws IOException{
        socket.close();
    }
    public String toString(){
        return socket.toString();
    }
    
}
