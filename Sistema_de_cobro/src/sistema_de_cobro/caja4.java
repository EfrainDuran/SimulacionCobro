
package sistema_de_cobro;

import java.awt.Color;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class caja4 extends Thread {
    
    LinkedList cola;
    JButton bot1,botsal;
    int[] tec;
    int[] product;
    int[] tiempoenllegar;
    JButton bt[][];
    JLabel cuentclient;
    int d=0;
    
    public caja4(LinkedList col, JButton boton1, int[] tiempcaj, int[] prod, int[] tell, JButton[][] but,JLabel cuentaclientes,JButton botonsalir) {
        this.cola = col;
        this.bot1 = boton1;
        this.tec = tiempcaj;
        this.product = prod;
        this.tiempoenllegar = tell;
        this.bt = but;
        this.cuentclient=cuentaclientes;
        this.botsal=botonsalir;
    }

  
    
    public void run() {

        try {
            cajas.sleep(tiempoenllegar[0]*1000+100);
        } catch (InterruptedException ex) {
            Logger.getLogger(cajas.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0;  cola.size()!=0; i++) {
            bot1.setBackground(Color.red);
            bot1.setText("Ocupado");
            cola.pop();///////////////////////////////////////
            for (int j = 0; j < 15; j++) {
                for (int k = 0; k < 15; k++) {
                    bt[j][k].setBackground(Color.gray);
                }
            }
            int y = 0,c=0;
                for (int j = 0; j < cola.size(); j++) {
                    if (c == 15) {
                       y++;
                       c=0;
                    }
                    bt[y][c].setBackground(Color.green);
                    c++;
                }
            try {
                cajas.sleep(1764);
            } catch (InterruptedException ex) {
                Logger.getLogger(cajas.class.getName()).log(Level.SEVERE, null, ex);
            }
            d++;
            cuentclient.setText(d+"");
            bot1.setBackground(Color.green);
            bot1.setText("Libre");
            botsal.setBackground(Color.green);
            try {
                cajas.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(cajas.class.getName()).log(Level.SEVERE, null, ex);
            }
            botsal.setBackground(Color.red);
        }

    }
}
