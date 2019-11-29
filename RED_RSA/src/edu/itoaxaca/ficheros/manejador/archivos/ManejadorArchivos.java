/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itoaxaca.ficheros.manejador.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author laibr
 */
public class ManejadorArchivos {
    
    public ManejadorArchivos() {
    }
    
    public static List<String[]> leerDatos(String ruta) throws FileNotFoundException{
        List<String[]> data = new ArrayList<>();
        File archivo = new File(ruta);
        Scanner input = new Scanner(archivo);
        while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
                String[] datos = line.split(",");
                data.add(datos);
    }
        return data;
    }
    
    public static File crearFichero(String ruta, String nombre,String extension) throws IOException {
        File fichero = new File(ruta, nombre + "." + extension);
        fichero.createNewFile();
        return fichero;
    }
    
}
