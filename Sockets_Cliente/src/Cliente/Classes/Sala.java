/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.Classes;

import java.util.ArrayList;

/**
 *
 * @author dlpires
 */
public class Sala {
    
    private String nomeSala;
    private ArrayList<Jogador> jogadores;
    private ArrayList<Character> alfabeto;

    
    public Sala(){
        jogadores = new ArrayList<>();
        alfabeto = new ArrayList<>();
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
    
}
