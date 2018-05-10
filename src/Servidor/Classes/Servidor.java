/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author diego.pires
 */
public class Servidor extends Thread{
    private static ArrayList<BufferedWriter> clientes;           
    private static ServerSocket server; 
    private String nome;
    private Socket con;
    private InputStream in;  
    private InputStreamReader inr;  
    private BufferedReader bfr;
    
     /**
  * Método construtor 
  * @param com do tipo Socket
  */
    public Servidor(Socket con){
       this.con = con;
       try {
             in  = con.getInputStream();
             inr = new InputStreamReader(in);
             bfr = new BufferedReader(inr);
       } catch (IOException e) {
              e.printStackTrace();
       }                          
    }
    
    /**
    * Método run
    */
    public void run(){

      try{

        //String msg;
        OutputStream ou =  this.con.getOutputStream();
        Writer ouw = new OutputStreamWriter(ou);
        BufferedWriter bfw = new BufferedWriter(ouw); 
        clientes.add(bfw);
        /*nome = msg = bfr.readLine();

        while(!"Sair".equalsIgnoreCase(msg) && msg != null)
          {           
           msg = bfr.readLine();
           sendToAll(bfw, msg);
           System.out.println(msg);                                              
           }*/

       }catch (Exception e) {
         e.printStackTrace();

       }                       
    }
    
    public void sendToAll(BufferedWriter bwSaida, String msg) throws  IOException {
      BufferedWriter bwS;

      for(BufferedWriter bw : clientes){
       bwS = (BufferedWriter)bw;
       if(!(bwSaida == bwS)){
         bw.write(nome + " -> " + msg+"\r\n");
         bw.flush(); 
       }
      }          
    }
}