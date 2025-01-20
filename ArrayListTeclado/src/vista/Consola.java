
package vista;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Teclado;

/**
 *
 * @author sergi.carmona
 */
public class Consola {
    

    public Teclado pideDatos() {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Teclado> Teclados = new ArrayList<>();
        Teclado TecladoActual = new Teclado();
        
        // Rellenamos los equipos en los que ha estado el deportista
        Teclado tecladoActual = null;
        for (int x = 0; x < 3; x++) {
            tecladoActual = new Teclado();    // Reservamos un nuevo espacio de memoria
            System.out.print("Marca: ");
            tecladoActual.setMarca(teclado.nextLine());
            System.out.print("Modelo: ");
            tecladoActual.setModelo(teclado.nextLine());
            System.out.print("Numero de teclas: ");
            tecladoActual.setNumTeclas(teclado.nextInt());
            teclado.nextLine();
            
            // A�adir el equipo a un ArrayList de equipos donde ha jugado
            Teclados.add(tecladoActual);
        }
        // A�adir el ArrayList al objeto deportistaActual
        TecladoActual.setArrTeclado(Teclados);
        
        
        return TecladoActual;
    }
    
    public void leeTeclado(Teclado TecladoActual){
        System.out.println("==============================");
        for(Teclado e : TecladoActual.getArrTeclado()){
            System.out.println("\tNombre del equipo: " + e.getMarca());
            System.out.println("\tLocalidad del equipo: " + e.getModelo());
            System.out.println("\tA�o de fundaci�n: " + e.getNumTeclas());
        }
    }
}
