package escribiendoenword;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.*;


public class EscribiendoEnWord {

    public static void main(String[] args) throws Exception {
        // Crear un documento
        XWPFDocument documento = new XWPFDocument();
        
        // Crear un p�rrafo
        XWPFParagraph parrafo = documento.createParagraph();
        
        // Crear un "run" para escribir texto en el p�rrafo
        XWPFRun ejecutador = parrafo.createRun();
        ejecutador.setText("Vamos chavales!!!");
        
        // Guardamos el texto en un fichero
        try (FileOutputStream fichero = new FileOutputStream("word guap�simo.docx")) {
            // Escribimos en el documento
            documento.write(fichero);
            // Mostramos un mensaje al usuario indicando que todo ha ido bien
            System.out.println("Word creado correctamente ;)");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
