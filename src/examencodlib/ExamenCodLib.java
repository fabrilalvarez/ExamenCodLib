/*
 * Examen COD Librerias de twitter.
 */
package examencodlib;

import javax.swing.JOptionPane;

/**
 *
 * @author @FranJAbrilA <ffrannabril@gmail.com>
 */
public class ExamenCodLib {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        AcesoTwitter twiiit = new AcesoTwitter();

        // Opcion elige la opcion del menu en el switch.
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("1 --> Linea de Tiempo\n2 --> Buscar un Tweet\n3 --> Tweetear\n4 --> Cerrar"));
            switch (opcion) {
                case 1:
                    twiiit.timeLine();
                    break;
                case 2:
                    twiiit.search();
                    break;
                case 3:
                    twiiit.tweet();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.exit(0);
            }
        } while (opcion != 0 && opcion != 5);
    }
}
