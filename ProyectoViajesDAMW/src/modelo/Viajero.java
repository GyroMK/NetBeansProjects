package modelo;

import java.util.ArrayList;

/**
 *
 * @author sergi.carmona
 */
public class Viajero {

    private String nombre;
    private int edad;
    private int numViajes;
    private ArrayList<Viajes> ArrViajes;

    public Viajero() {
        this.nombre = "";
        this.edad = 0;
        this.numViajes = 0;
    }

    public Viajero(String nombre, int edad, int numViajes) {
        this.nombre = nombre;
        this.edad = edad;
        this.numViajes = numViajes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumViajes() {
        return numViajes;
    }

    public void setNumViajes(int numViajes) {
        this.numViajes = numViajes;
    }

    public ArrayList<Viajes> getArrViajes() {
        return ArrViajes;
    }

    public void setArrViajes(ArrayList<Viajes> ArrViajes) {
        this.ArrViajes = ArrViajes;
    }

}
