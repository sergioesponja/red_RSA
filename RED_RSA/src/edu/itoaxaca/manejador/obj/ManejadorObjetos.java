/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itoaxaca.manejador.obj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author laibr
 */
public class ManejadorObjetos {

    public ManejadorObjetos() {
    }

    public static void writeObj(Object o, File fichero) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
        oos.writeObject(o);
        oos.close();
    }

    public static Object readObj(File fichero) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
        Object aux = ois.readObject();
        return aux;
    }

    public static File crearFichero(String ruta, String nombre,String extension) throws IOException {
        File fichero = new File(ruta, nombre + "." + extension);
        fichero.createNewFile();
        return fichero;
    }
}
