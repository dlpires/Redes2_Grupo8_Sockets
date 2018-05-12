/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Classes;

import java.util.HashMap;

/**
 *
 * @author dlpires
 */
public class Jogador {

    private String apelido;
    private HashMap <String, String> respostas;
    private Integer pontuacaoNestaRodada;
    private Integer pontuacaoParcial;
    
    public Jogador(){
        respostas = new HashMap<>();
    }
    
    /**
     * @return the apelido
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * @param apelido the apelido to set
     */
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    /**
     * @return the respostas
     */
    public HashMap <String, String> getRespostas() {
        return respostas;
    }

    /**
     * @param respostas the respostas to set
     */
    public void setRespostas(HashMap <String, String> respostas) {
        this.respostas = respostas;
    }

    /**
     * @return the pontuacaoNestaRodada
     */
    public Integer getPontuacaoNestaRodada() {
        return pontuacaoNestaRodada;
    }

    /**
     * @param pontuacaoNestaRodada the pontuacaoNestaRodada to set
     */
    public void setPontuacaoNestaRodada(Integer pontuacaoNestaRodada) {
        this.pontuacaoNestaRodada = pontuacaoNestaRodada;
    }

    /**
     * @return the pontuacaoParcial
     */
    public Integer getPontuacaoParcial() {
        return pontuacaoParcial;
    }

    /**
     * @param pontuacaoParcial the pontuacaoParcial to set
     */
    public void setPontuacaoParcial(Integer pontuacaoParcial) {
        this.pontuacaoParcial = pontuacaoParcial;
    }
    
}
