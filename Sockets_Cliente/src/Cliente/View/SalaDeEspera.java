/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.View;

import Cliente.Classes.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author dlpires
 */
public class SalaDeEspera extends javax.swing.JFrame {
    
    /**
     * Creates new form SalaDeEspera
     */
    
    private Conexao con;
    private Jogador jogador;
    
    public SalaDeEspera(Conexao con, Jogador jogador) throws UnknownHostException, IOException, ClassNotFoundException {
        initComponents();
        setLocationRelativeTo(null);
        
        //RECEBENDO OBJETOS
        this.con = con;
        this.jogador = jogador;
        
        //COLOCA AS INFORMAÇÕES DO SERVIDOR
        setServidor();
        
        //ATUALIZA LISTA AUTOMATICAMENTE, A CADA 10 SEGUNDOS
        atualizaDados();
        
        iniciarJogo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaParticip = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        dadosServer = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sala de Espera");

        listaParticip.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaParticip.setToolTipText("");
        listaParticip.setEnabled(false);
        listaParticip.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaParticipValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaParticip);

        jLabel1.setText("Participantes:");

        dadosServer.setText("Servidor: <IP>:<Porta>");

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(dadosServer))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(cancelar)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(dadosServer)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(cancelar)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        try {
            con.close();
            
            new PaginaInicial().setVisible(true);
            this.dispose();
            
        } catch (IOException ex) {
            Logger.getLogger(SalaDeEspera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancelarActionPerformed

    private void listaParticipValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaParticipValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listaParticipValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel dadosServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaParticip;
    // End of variables declaration//GEN-END:variables

    private void setServidor() {
        dadosServer.setText("Servidor: " + con.getIp() + ":" + con.getPorta());
    }

    
    //AUTOMATIZA A ATUALIZAÇÃO DA JLIST
    private void atualizaDados(){
        long intervaloDeAtualizacao = 1000; // intervalo de 1 segundos  
        Timer timer = new Timer();
        
        if (timer == null) {
                   timer = new Timer();
                   TimerTask tarefa = new TimerTask() {
                       @Override
                       public void run() {
                           try {
                              atualizaLista();
                              iniciarJogo();
                           } catch (Exception e) {
                               e.printStackTrace();
                           }
                       }
                   };
                   timer.scheduleAtFixedRate(tarefa, intervaloDeAtualizacao, intervaloDeAtualizacao);
        }
    }
    
    //ATUALIZA A JLIST
    private void atualizaLista() throws IOException, ClassNotFoundException {
        ArrayList<String> lista = (ArrayList<String>) con.readObject();
        DefaultListModel l = new DefaultListModel();
        
        //FOREACH PARA INSERIR DADOS EM UM DEFAULT LIST MODEL
        lista.forEach((s) -> {
            l.addElement(s);
        });
        
        //ADICIONANDO DADOS A LISTA
        listaParticip.setModel(l);
    }

    private void iniciarJogo() throws IOException {
        String response = con.readString();
        if ("start".equalsIgnoreCase(response)){
            new Jogo(con, jogador).setVisible(true);
            this.dispose();
        }
    }
    
}
