package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import modelo.Ropa;
import vista.Consola;

/**
 *
 * @author gonzalo.detomas
 */
public class BaseDeDatos {

    public void consultaGenerico() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_tienda", "root", "");
            Statement consulta = conexion.createStatement();
            ResultSet registro = consulta.executeQuery("select idArticulo, descripcion, tipoPrenda, precio "
                    + "from ropa");

            // Mostrar la informaci�n en forma de tabla
            System.out.println("idArticulo\tDescripcion\t\tTipo de Prenda\t\tPrecio");
            while (registro.next()) {
                System.out.print("\t" + registro.getString("idArticulo"));
                System.out.print("\t" + registro.getString("descripcion"));
                System.out.print("\t\t" + registro.getString("tipoPrenda"));
                System.out.println("\t\t" + registro.getString("precio"));
            }
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultaPrenda(Ropa prenda) {
        Scanner teclado = new Scanner(System.in);
        Consola c = new Consola();

        // NOS SOBRAN LAS DOS SIGUIENTES L�NEAS
        //System.out.print("Introduzca el idArticulo a buscar: ");
        //int idArticulo = teclado.nextInt();
        ResultSet registro = null;
        Ropa prendaActual = new Ropa();

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_tienda", "root", "");
            Statement consulta = conexion.createStatement();

            // Preguntamos por el idArticulo
            if (prenda.getIdArticulo() != -9) {
                registro = consulta.executeQuery("select idArticulo, tipoPrenda, tipoMaterial,"
                        + "descripcion, talla, precio "
                        + "from ropa where idArticulo="
                        + prenda.getIdArticulo());
            } else if (!prenda.getTipoPrenda().equals("ERROR")) { // Preguntamos por la descripci�n
                registro = consulta.executeQuery("select idArticulo, tipoPrenda, tipoMaterial,"
                        + "descripcion, talla, precio "
                        + "from ropa where tipoPrenda='"
                        + prenda.getTipoPrenda() + "'");
            } else if (prenda.getPrecio() != -9.9f) {
                registro = consulta.executeQuery("select idArticulo, tipoPrenda, tipoMaterial,"
                        + "descripcion, talla, precio "
                        + "from ropa where precio<="
                        + prenda.getPrecio());
            }

            // Si encuentro una fila (registro)
            if (registro.next()) {
                do {
                    prendaActual.setIdArticulo(Integer.parseInt(registro.getString("idArticulo")));
                    prendaActual.setTipoPrenda(registro.getString("tipoPrenda"));
                    prendaActual.setTipoMaterial(registro.getString("tipoMaterial"));
                    prendaActual.setDescripcion(registro.getString("descripcion"));
                    prendaActual.setTalla(registro.getString("talla"));
                    prendaActual.setPrecio(Float.parseFloat(registro.getString("precio")));

                    c.muestraDatos(prendaActual);
                } while (registro.next());  // Seguimos preguntando mientras siga encontrando registros
            }

            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertaRopa(Ropa miRopa) {
        Consola c = new Consola();

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_tienda", "root", "");
            Statement consulta = conexion.createStatement();

            consulta.executeUpdate("insert into ropa (tipoPrenda, tipoMaterial, descripcion, talla, precio) "
                    + "values ('" + miRopa.getTipoPrenda() + "', '"
                    + miRopa.getTipoMaterial() + "', '"
                    + miRopa.getDescripcion() + "', '"
                    + miRopa.getTalla() + "',"
                    + miRopa.getPrecio() + ")");
            conexion.close();
            System.out.println("Art�culo guardado correctamente");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void modificarRopa(Ropa miRopa) {
        Connection conexion;

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_tienda", "root", "");
            Statement consulta = conexion.createStatement();
            System.out.println("update ropa set tipoPrenda = '"
                    + miRopa.getTipoPrenda() + "', tipoMaterial = '"
                    + miRopa.getTipoMaterial() + "', descripcion = '"
                    + miRopa.getDescripcion() + "', talla = '"
                    + miRopa.getTalla() + "', precio = "
                    + miRopa.getPrecio() + " where idArticulo = " + miRopa.getIdArticulo());

            int valor = consulta.executeUpdate("update ropa set tipoPrenda = '"
                    + miRopa.getTipoPrenda() + "', tipoMaterial = '"
                    + miRopa.getTipoMaterial() + "', descripcion = '"
                    + miRopa.getDescripcion() + "', talla = '"
                    + miRopa.getTalla() + "', precio = "
                    + miRopa.getPrecio() + " where idArticulo = " + miRopa.getIdArticulo());

            if (valor == 1) {
                System.out.println("Art�culo modificado correctamente");
            } else {
                System.out.println("No existe un art�culo con dicho identificador");
            }
            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void borrarRopa() {
        Consola c = new Consola();
        int idArticulo = c.pideEntero("Introduzca el id del art�culo a borrar: ");
        Connection conexion;
        int confirmar;

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_tienda", "root", "");
            Statement consulta = conexion.createStatement();

            System.out.println("�Est� seguro que desea borrar el art�culo?\n1.Borrar\n2.Cancelar");
            confirmar = c.pideEntero("Introduzca el n�mero de la opci�n: ");
            if (confirmar ==1) {

                int valor = consulta.executeUpdate("delete from ropa where idArticulo="
                        + idArticulo);

                if (valor == 1) {
                    System.out.println("Art�culo borrado correctamente");
                } else {
                    System.out.println("No existe un art�culo con dicho identificador");
                }
            } else {
                System.out.println("Operaci�n cancelada");
            }
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
