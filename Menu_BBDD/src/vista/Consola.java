package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import jdk.jfr.Description;
import modelo.tienda;

/**
 *
 * @author sergi.carmona
 */
public class Consola {

    public void Menu() {
        tienda t = new tienda();
        int opcion;
        do {
            Scanner teclado = new Scanner(System.in);
            System.out.println("1. Insertar Articulo");
            System.out.println("2. Consultar Articulo");
            System.out.println("3. Modificar Articulo");
            System.out.println("4. Borrar Articulo");
            System.out.println("5. Salir");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    BBDD(opcion, t);
                    break;
                case 2:
                    BBDD(opcion, t);
                    break;
                case 3:
                    BBDD(opcion, t);
                    break;
                case 4:
                    BBDD(opcion, t);
                    break;
            }
        } while (opcion < 4 || opcion > 1);
    }

    public void BBDD(int opcion, tienda tienda) {
        Scanner teclado = new Scanner(System.in);
        tienda t = tienda;
            switch (opcion) {
                case 1:
                    System.out.print("Introduzca el tipo de prenda del artículo: ");
                    String tipoPrenda = teclado.nextLine();
                    System.out.print("Introduzca el tipo de material del artículo: ");
                    String tipoMaterial = teclado.nextLine();
                    System.out.print("Introduzca la descripción del artículo: ");
                    String descripcion = teclado.nextLine();
                    System.out.print("Introduzca la talla del artículo: ");
                    String talla = teclado.nextLine();
                    System.out.print("Introduzca un precio del artículo: ");
                    float precio = teclado.nextFloat();

                    try {
                        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_tienda", "root", "");

                        Statement consulta = conexion.createStatement();
                        consulta.executeUpdate("insert into ropa (tipoPrenda, tipoMaterial, descripcion, talla, precio) values ('"
                                + tipoPrenda + "',"
                                + "'" + tipoMaterial + "',"
                                + "'" + descripcion + "','" + talla + "'," + precio + ")");
                        conexion.close();
                        System.out.println("Artículo guardado correctamente");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    
                    

                    try {
                        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_tienda", "root", "");
                        Statement consulta = conexion.createStatement();
                        
                        ResultSet registro = consulta.executeQuery("select idArticulo, tipoPrenda, tipoMaterial, descripcion, talla, precio from ropa");

                        while (registro.next()){
                            int id = registro.getInt("idArticulo");
                            System.out.println("Tipo de prenda: " + id);
                            String prenda = registro.getString("tipoPrenda");
                            System.out.println("Tipo de prenda: " + prenda);
                            String material = registro.getString("tipoMaterial");
                            System.out.println("Tipo de material: " + material);
                            String desc = registro.getString("descripcion");
                            System.out.println("Descripción: " + desc);
                            talla = registro.getString("talla");
                            System.out.println("Talla: " + talla);
                            System.out.println("Precio: " + registro.getString("precio"));
                        }
                        
                        System.out.print("Introduzca el idArticulo a buscar: ");
                        int idArticulo = teclado.nextInt();
                        ResultSet filtrado = consulta.executeQuery("select idArticulo, tipoPrenda, tipoMaterial, descripcion, talla, precio "
                                + "from ropa where idArticulo="
                                + idArticulo);
                        
                        conexion.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.print("Introduzca el idArticulo a modificar: ");
                    int idArticulo = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Introduzca el tipo de prenda a modificar: ");
                    tipoPrenda = teclado.nextLine();
                    System.out.print("Introduzca el tipo de material a modificar a modificar: ");
                    tipoMaterial = teclado.nextLine();
                    System.out.print("Introduzca la descripción a modificar: ");
                    descripcion = teclado.nextLine();
                    System.out.print("Introduzca la talla a modificar: ");
                    talla = teclado.nextLine();
                    System.out.print("Introduzca el precio a modificar: ");
                    precio = teclado.nextFloat();

                    Connection conexion;
                    try {
                        conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_articulos", "root", "");
                        Statement consulta = conexion.createStatement();

                        int valor = consulta.executeUpdate("update articulos set descripcion ='"
                                + descripcion + "', precio=" + precio + " where idArticulo=" + idArticulo);

                        if (valor == 1) {
                            System.out.println("Artículo modificado correctamente");
                        } else {
                            System.out.println("No existe un artículo con dicho identificador");
                        }
                        conexion.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
            }

    }
    
    public void subMenuFilter(tienda tienda) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        tienda t = tienda;
        do {
            System.out.println("Como quieres filtrar");
            System.out.println("1. idArticulo");
            System.out.println("2. Tipo de prenda");
            System.out.println("3. Precio");
            opcion = teclado.nextInt();
            
            switch(opcion) {
                case 1:
                    
                    break;
            }
        } while (opcion < 4 || opcion > 1);
    }
}
