package sistema_de_cobro;

import java.awt.Color;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

public class hilos extends Thread {

//declara variables
    JLabel etiquetacliente, etiquetatiempo, etitotalcliente;
    int[] numcliente;
    int[] tiempo;
    JButton[][] bt;
    LinkedList cola;
    int totalclientes=0;
    
//constructor llama variables de la clase NewJFrame 
    public hilos(JLabel label, JLabel label2, int[] client, int[] tiemp, JButton[][] button,LinkedList col, int tc,JLabel jlabel13) {
        this.etiquetacliente = label;
        this.etiquetatiempo = label2;
        this.numcliente = client;
        this.tiempo = tiemp;
        this.bt = button;
        this.cola=col;
        this.totalclientes=tc;
        this.etitotalcliente=jlabel13;
    }
    
    public void run() {
        
        for (int i = 0; i < 50; i++) {
            try {
                etiquetacliente.setText(numcliente[i] + " personas");
                etiquetatiempo.setText(tiempo[i] + " segundos");
                hilos.sleep(tiempo[i] * 500);
                for (int j = 0; j < numcliente[i]; j++) {
                    cola.add("1");
                    totalclientes++;
                    etitotalcliente.setText(totalclientes+"");
                }
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
                
            } catch (InterruptedException ex) {
                Logger.getLogger(hilos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
