package manejodebbdd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertandoDatos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduzca una descripci�n para el art�culo: ");
        String descripcion = teclado.nextLine();
        System.out.print("Introduzca un precio para el art�culo: ");
        float precio = teclado.nextFloat();
        //String nombre = "Gonzalo";
        try {										// Java Data Base Connection
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_articulos", "root", "");

            Statement consulta = conexion.createStatement();
            consulta.executeUpdate("insert into articulos (descripcion, precio) values ('"
                    + descripcion + "'," + precio + ")");
            conexion.close();
            System.out.println("Art�culo guardado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
