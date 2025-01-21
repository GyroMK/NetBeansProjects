package Controlador;

import Modelo.Pelicula;
import Vista.Consola;
import java.util.Scanner;

/**
 *
 * @author sergi.carmona
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Consola c = new Consola();
        Scanner teclado = new Scanner(System.in);
        Pelicula p = null;

        int menu = teclado.nextInt();

        do {
            switch (menu) {
                case 1:
                    p = c.pideDatos();
                case 2:
                    c.muestraDatos(p);
                    break;
            }

        } while (menu > 4 || menu < 1);

    }

}
