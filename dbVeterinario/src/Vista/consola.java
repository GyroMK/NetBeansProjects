
package Vista;

import Modelo.mascotas;
import java.util.Scanner;

/**
 *
 * @author sergi.carmona
 */
public class consola {
    
    public String pideCadena(String pregunta) {
        Scanner teclado = new Scanner(System.in);
        System.out.print(pregunta);

        return teclado.nextLine();
    }

    public int pideEntero(String pregunta) {
        Scanner teclado = new Scanner(System.in);
        System.out.print(pregunta);

        return teclado.nextInt();
    }
    
    public mascotas pideDatos() {
        mascotas MascotaActual = new mascotas();
        int edadMascota;
        MascotaActual.setNombre(pideCadena("Introduzca el nombre de la mascota: "));
        MascotaActual.setTipoAnimal(pideCadena("Introduzca el tipo de animal: "));
        
        do {
            edadMascota = pideEntero("Introduzca la talla: ");
        } while (edadMascota > 3);
        MascotaActual.setEdad(edadMascota);
        
        //MascotaActual.setEdad(pideEntero("Introduzca la edad de la mascota: "));
        MascotaActual.setDescripcionSintomas(pideCadena("Introduzca los sitnomas que tiene: "));
        MascotaActual.setVacunas(pideCadena("Introduzca las vacunas que tiene: "));

        return MascotaActual;
    }
    
    
}
