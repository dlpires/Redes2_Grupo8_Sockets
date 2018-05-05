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
    private List<String> alfabeto;
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
    public List<String> getAlfabeto() {
        return alfabeto;
    }

    /**
     * @param alfabeto the alfabeto to set
     */
    public void setAlfabeto(List<String> alfabeto) {
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
