package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author sergi.carmona
 */
//
//                    System.out.println(propiedades.getProperty("nombre"));
//                    System.out.println(propiedades.getProperty("edad"));
//                    System.out.println(propiedades.getProperty("numViajes"));
//                    System.out.println(propiedades.getProperty("destino"));
//                    System.out.println(propiedades.getProperty("tiempo"));
//                    System.out.println(propiedades.getProperty("familia"));
//                    System.out.println(propiedades.getProperty("amigos"));
//                    System.out.println(propiedades.getProperty("solo"));
//                    System.out.println(propiedades.getProperty("valoracion"));
//                    System.out.println(propiedades.getProperty("insertar"));
//                    System.out.println(propiedades.getProperty("consultar"));
//                    System.out.println(propiedades.getProperty("generar"));
//                    System.out.println(propiedades.getProperty("salir"));
//                    System.out.println(propiedades.getProperty("mensajeOK"));
//                    System.out.println(propiedades.getProperty("mensajeMAL"));
//                    System.out.println(propiedades.getProperty("usuarioOK"));
//                    System.out.println(propiedades.getProperty("sqlOK"));
public class Consola {

    Properties propiedades = new Properties();
    InputStream entrada = null;

    

    public void Menu() {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        try {
            do {
                System.out.println("1. Spanish");
                System.out.println("2. English");
                System.out.println("3. French");
                
                opcion = teclado.nextInt();
                
                
                if (opcion >= 1 && opcion <= 3) {
                    switch (opcion) {
                        case 1:
                            entrada = new FileInputStream("esp.properties");
                            MenuUsuario();
                            break;
                        case 2:
                            entrada = new FileInputStream("ing.properties");
                            MenuUsuario();
                            break;
                        case 3:
                            entrada = new FileInputStream("fra.properties");
                            MenuUsuario();
                            break;
                    }

                } else if (opcion == 0) {
                    System.out.println("Bai bai\n\n");
                } else {
                    System.out.println("Elija una opcion correcta\n");
                }

            } while (opcion != 0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public void MenuUsuario() throws IOException {
        propiedades.load(entrada);
        Scanner teclado = new Scanner(System.in);
        int user;

        do {
            System.out.println("1. " + propiedades.getProperty("insertar"));
            user = teclado.nextInt();
            switch (user) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
            user = teclado.nextInt();

        } while (user < 5 || user > 1);

    }
    
    
}
