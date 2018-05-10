/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dlpires
 */
public class Sala {
    
    private String nomeSala;
    private ArrayList<Jogador> jogadores;
    private ArrayList<Character> alfabeto;
    private Conexao conexao;

    
    public Sala(){
        jogadores = new ArrayList<>();
        alfabeto = new ArrayList<>();
        conexao = new Conexao();
    }
    
    /**
     * @return the jogadores
     */
    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    /**
     * @param jogadores the jogadores to set
     */
    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    /**
     * @return the nomeSala
     */
    public String getNomeSala() {
        return nomeSala;
    }

    /**
     * @param nomeSala the nomeSala to set
     */
    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    /**
     * @return the alfabeto
     */
    public ArrayList<Character> getAlfabeto() {
        return alfabeto;
    }

    public String getAlfabetoString(){
        String finalStr = "";
		for (Character str : alfabeto) {
			if (finalStr.trim().isEmpty()) {
				finalStr = str.toString();
			} else {
				finalStr = finalStr + "," + str;
			}
		}
	return finalStr;
    }
    
    /**
     * @param alfabeto the alfabeto to set
     */
    public void setAlfabeto(ArrayList<Character> alfabeto) {
        this.alfabeto = alfabeto;
    }

    /**
     * @return the conexao
     */
    public Conexao getConexao() {
        return conexao;
    }

    /**
     * @param conexao the conexao to set
     */
    public void setConexao(Conexao conexao) {
        this.conexao = conexao;
    }
    
}
