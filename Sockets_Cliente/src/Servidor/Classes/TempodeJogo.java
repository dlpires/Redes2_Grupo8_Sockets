/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Classes;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author willi
 */
public class TempodeJogo {
    Timer timer;
    javax.swing.JLabel EscrTemp;
    /**
     * @param args the command line arguments
     */
    public TempodeJogo(javax.swing.JLabel Lbtempo) {
        timer = new Timer();
        EscrTemp = Lbtempo;
        timer.schedule(new RemindTask(), 0, 1000);
    }

    class RemindTask extends TimerTask {
        int i=30;
        public void run() {
            AtualizaTempo();
        }

        private void AtualizaTempo() {
            EscrTemp.setText("Tempo: " + i);
            
            if(i==0){
                EscrTemp.setText("Acabou o tempo");
                timer.cancel();
            }
            i--;
        }
    }
}
