/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author dlpires
 */
public class Conexao {

    private Socket socket;
    private String ip;
    private Integer porta;
    
    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the porta
     */
    public Integer getPorta() {
        return porta;
    }

    /**
     * @param porta the porta to set
     */
    public void setPorta(Integer porta) {
        this.porta = porta;
    }
    
    //CONEXÃO SERVIDOR
    public void connectServer(int porta) throws IOException {
        ServerSocket serverSocket = new ServerSocket(porta);
        this.porta = porta;
        socket = serverSocket.accept();
    }
    
    //CONEXÃO CLIENTE
    public void connectClient(String ip, int porta) throws UnknownHostException, IOException {
        socket = new Socket(ip, porta);
        this.ip = ip;
        this.porta = porta;
    }
    
    //FECHA A CONEXÃO DO SOCKET
    public void close() throws IOException {
        socket.close();
    }
    
    //MANDA O OBJETO JOGADOR
    public void writeJogador(Jogador jogador) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(jogador);
    }
    
    //LE O OBJETO ENVIADO
    public Object read() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        return in.readObject();
    }
}
