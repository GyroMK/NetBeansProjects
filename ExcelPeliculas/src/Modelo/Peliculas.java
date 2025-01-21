package Modelo;

import java.util.ArrayList;

/**
 *
 * @author sergi.carmona
 */
public class Peliculas {
    public enum Generos {
        ACCIÓN, COMEDIA, ROMANCE, TERROR, CIENCIA_FICCIÓN
    }

    private String nombre;
    private int duracion;
    private String pais;
    private String director;
    private float valoracion;
    private int numPremios;
    private ArrayList<Premios> arrPremios;
    
    
    public Peliculas(){
    
    this.nombre = "";
    this.duracion = 0;
    this.pais = "";
    this.director = "";
    this.valoracion = 0;
    this.numPremios = 0;
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public int getNumPremios() {
        return numPremios;
    }

    public void setNumPremios(int numPremios) {
        this.numPremios = numPremios;
    }

    public ArrayList<Premios> getArrPremios() {
        return arrPremios;
    }

    public void setArrPremios(ArrayList<Premios> arrPremios) {
        this.arrPremios = arrPremios;
    }
}
