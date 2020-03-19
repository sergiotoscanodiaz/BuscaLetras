package buscaletras;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class buscaLetras {

  public static void main(String[] args) {
    
     if (args.length != 3) {
      System.out.println("Introduce en el terminal java buscaLetras buscaLetras.java a letra.txt, por ejemplo");
      System.exit(-1);
    }
    try {
      BufferedReader br = new BufferedReader(new FileReader(args[0]));
      BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
      String lineas = "";
      boolean contiene = false;
      int contadorDeLineas = 0;
      do {
        lineas = br.readLine();
        if (lineas == null) {
          break;
        }
        if (lineas.contains(args[1])) {
          System.out.print(contadorDeLineas + " : ");
          System.out.println(lineas);
          contiene = true;
          bw.write(contadorDeLineas + " : " + lineas + "\n");
        }
        contadorDeLineas++;
      } while (lineas != null);

      br.close();
      bw.close();

      if (!contiene) {
        System.out.println("No se han encontrado palabras");
        System.exit(0);
      }
    } catch (IOException ioe) {
      System.out.println("No se ha podido leer el archivo correctamente");
    }
    
  }
  
}
