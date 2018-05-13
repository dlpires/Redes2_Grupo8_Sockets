/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.Classes;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author dlpires
 * 
 * FAZ A CONEXÃO E COMUNICAÇÃO
 */
public class Conexao {

    private Socket socket;
    private String ip;
    private int porta;
    
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
    public int getPorta() {
        return porta;
    }

    /**
     * @param porta the porta to set
     */
    public void setPorta(int porta) {
        this.porta = porta;
    }
    
    //CONEXÃO CLIENTE
    public void connectClient(String ip, int porta) throws UnknownHostException, IOException {
        socket = new Socket(ip, porta);
        this.setIp(ip);
        this.setPorta(porta);
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
    public Object readObject() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        return in.readObject();
    }
}
