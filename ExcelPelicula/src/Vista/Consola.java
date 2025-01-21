package Vista;

import Modelo.Pelicula;
import Modelo.Pelicula.Genero;
import Modelo.Premios;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sergi.carmona
 */
public class Consola {

    public Pelicula pideDatos() {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Premios> PremiosGanados = new ArrayList<>();
        Pelicula peliculaActual = new Pelicula();

        System.out.print("Nombre: ");
        peliculaActual.setNombre(teclado.nextLine());
        System.out.print("Duracion: ");
        peliculaActual.setDuracion(teclado.nextInt());
        System.out.print("Pais: ");
        peliculaActual.setPais(teclado.nextLine());
        System.out.print("Director: ");
        peliculaActual.setDirector(teclado.nextLine());
        System.out.print("valoracion: ");
        peliculaActual.setValoracion(teclado.nextFloat());
        return peliculaActual;

        Premios premioActual = null;
        for (int x = 0; x < peliculaActual.getNumPremios(); x++) {
            premioActual = new Premios();    // Reservamos un nuevo espacio de memoria
            System.out.print("Nombre del premio: ");
            premioActual.setNombrePremio(teclado.nextLine());
            System.out.print("Ciudad: ");
            premioActual.setCiudad(teclado.nextLine());
            
            PremiosGanados.add(premioActual);

        }
        peliculaActual.getArrPremios(PremiosGanados);
        return peliculaActual;
    }

    public String pideCadena(String pregunta) {
        Scanner teclado = new Scanner(System.in);
        String cadenaPedida;
        System.out.println(pregunta);
        cadenaPedida = teclado.nextLine();
        return cadenaPedida;
    }

    public int pideEntero(String pregunta) {
        Scanner teclado = new Scanner(System.in);
        int enteroPedido;
        System.out.println(pregunta);
        enteroPedido = teclado.nextInt();
        return enteroPedido;
    }

    public float pideDecimal(String pregunta) {
        Scanner teclado = new Scanner(System.in);
        float decimalPedido;
        System.out.println(pregunta);
        decimalPedido = teclado.nextFloat();
        return decimalPedido;
    }

    public Genero PideGenero() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Generos\n1.ACCIÓN\n2.COMEDIA\n3.ROMANCE\n4.TERROR\n5.CIENCIA FICCIÓN");
        System.out.println("Introduzca la opcion: ");
        int opcion = teclado.nextInt();
        do {

            switch (opcion) {
                case 1:
                    return Genero.ACCION;
                case 2:
                    return Genero.COMEDIA;
                case 3:
                    return Genero.ROMANCE;
                case 4:
                    return Genero.TERROR;
                case 5:
                    return Genero.CIENCIA_FICCION;

                default:
                    System.out.println("Introduze una opcion correcta");
            }
        } while (opcion > 4 || opcion < 1);
        return Genero.ACCION;
    }
}
