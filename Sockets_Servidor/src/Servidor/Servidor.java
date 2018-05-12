package Servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {
	private static ServerSocket ss;
	private Socket s;
	private final static int PORT = 12345;
	
	/** @author Renato
	 * Construtor simples onde você passa o Socket pro Servidor, extends Thread porque é um servidor Multi-Thread, onde
	 * cada thread faz o tratamento de um cliente.
	 * @param s
	 */
	
	public Servidor(Socket s) {
		this.s = s;
	}
	
	public void run() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(s.getInputStream());
			Object x = null;
			
			do {
				x = in.readObject();
				System.out.println(x.toString());
                                
                               /*if (x instanceof Cliente) {
					((Cliente) x).setIdade(((Cliente) x).getIdade() + 1);
					out.writeObject(x);
                                }*/
				
			} while (!(x instanceof String) && x != "fim");
			
			if (x instanceof String && x == "fim") {
				System.out.println(x);
				s.close();
				out.close();
				in.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		try {
			ss = new ServerSocket(PORT);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("Server Socket rodando na porta = "
				+ ss.getLocalPort());
		while (true) {
			try {  
				Socket conexao = ss.accept();
				new Servidor(conexao).start();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}	

	
}