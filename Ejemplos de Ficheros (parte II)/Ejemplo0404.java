import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// Escritura de bytes
public class Ejemplo0404 {

	public static void main(String[] args) throws IOException{
		// Escribimos una ruta existente
		String ruta = "C:\\adt";
		
		// Creamos el fichero
		File fichero = new File(ruta, "info.txt");
		
		// Creamos el flujo de entrada desde el fichero
		FileInputStream flujo = new FileInputStream(fichero);
		
		// Declaramos variables para el tama�o del fichero y para los bytes le�dos
		int tama�o = (int)fichero.length();
		byte[] datosLeidos = new byte[100];
		
		// Leemos del fichero
		System.out.println("Empezando a leer el fichero...");
		flujo.read(datosLeidos);
		
		// Mostramos los datos le�dos por consola
		for(int i=0; i<datosLeidos.length; i++){
			if(i%10 == 0)
				System.out.println();
			
			if(i != datosLeidos.length-1)
				System.out.print(datosLeidos[i] + ", ");
			else
				System.out.print(datosLeidos[i]);
		}
		
		flujo.close();
		System.out.println("\n\nFichero le�do correctamente!");
	}
}
