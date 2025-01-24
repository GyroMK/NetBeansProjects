package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;
import modelo.Viajero;
import modelo.Viajes;
import vista.Consola;

/**
 *
 * @author SERGI.CARMONA
 */
public class Ficheros {

    Consola c = new Consola();
    Properties propiedades = new Properties();

    public void escribir(ArrayList<Viajero> grupoViajero, String txt) throws IOException {
        File archivo = new File(txt);
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(new FileWriter(archivo), true);
            for (Viajero v : grupoViajero) {
                pw.println(v.getNombre());
                pw.println(v.getEdad());
                if (v.getNumViajes() == 0) {
                    pw.println(propiedades.getProperty("noViajes"));
                } else {
                    pw.println(v.getNumViajes());
                }
                for (Viajes vs : v.getArrViajes()) {
                    pw.println(vs.getDestino());
                    pw.println(vs.getTiempo());
                    if (vs.getAcompanyante() == Viajes.Acompanyante.AMIGOS) {
                        pw.println(propiedades.getProperty("amigos"));
                    } else if (vs.getAcompanyante() == Viajes.Acompanyante.FAMILIA) {
                        pw.println(propiedades.getProperty("familia"));
                    } else {
                        pw.println(propiedades.getProperty("solo"));
                    }
                    pw.println(vs.getValoracion());
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
        System.out.println(propiedades.getProperty("mensajeOK"));
    }
    
    public Viajero leer(){
        String cadena;
        FileReader f = null;

        try {
            f = new FileReader("peliculas.txt");

            BufferedReader br = new BufferedReader(f);
            while ((cadena = br.readLine()) != null) {
                System.out.println("nombre: " + cadena);
                System.out.println("duracion: " + br.readLine());
                System.out.println("pais: " + br.readLine());
                System.out.println("director: " + br.readLine());
                System.out.println("genero: " + br.readLine());
                System.out.println("========================================");
                System.out.println("\tnumero de premios: " + br.readLine());
                System.out.println("\tNombre del premio: " + br.readLine());
                System.out.println("\t3Ciudad del premio: " + br.readLine());
            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void EscribirHTML(Viajero viajero, String txt) throws IOException {
        File archivo = new File(txt);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(archivo), true);
            
                pw.println("<!DOCTYPE html>\n");
                pw.println("<html>\n");
                pw.println("\t<head>\n");
                pw.println("\t\t<title>" + v.getNombre() + "</title>\n");
                pw.println("\t</head>\n");
                pw.println("\t<body bgcolor=\"#000000\" text=\"white\">\n");
                pw.println("\t\t<table align=\"center\">\n");
                pw.println("\t\t\t\t<td align=\"center\"><b>" + v.getNombre() + "</b></td>\n");
            
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (pw != null) {
                pw.close();
            }
        }
            System.out.println(propiedades.getProperty("mensajeOK"));
        

    }
}
