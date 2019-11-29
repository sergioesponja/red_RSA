/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itoaxaca.ficheros.manejador.archivos;

import edu.itoaxaca.RSA.cripto.RSA;
import edu.itoaxaca.utilities.ConversorStrBin;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author laibr
 */
public class LecturaCSV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, UnsupportedEncodingException, NoSuchProviderException {

        List<String[]> datos = ManejadorArchivos.leerDatos("D:\\datos.csv");
        
        /*
        File fichero = ManejadorArchivos.crearFichero("D:\\", "datos2", "csv");
        FileWriter escritura = new FileWriter(fichero);
        RSA rsa = new RSA();
        rsa.genKeyPair(512);

        String file_private = "C:/xampp/php/tmp/rsa.pri";
        String file_public = "C:/xampp/php/tmp/rsa.pub";

        //Las guardamos asi podemos usarlas despues
        //a lo largo del tiempo
        rsa.saveToDiskPrivateKey("C:/xampp/php/tmp/rsa.pri");
        rsa.saveToDiskPublicKey("C:/xampp/php/tmp/rsa.pub");

        for (String[] obj : datos) {
            String normal = obj[0];
            if(normal.length() > 50){normal = normal.substring(0,50);}
            
            String secure = rsa.Encrypt(normal);

            escritura.append(normal);
            escritura.append(",");
            escritura.append(ConversorStrBin.toBinario(normal));
            escritura.append(",");
            escritura.append(secure);
            escritura.append(",");
            escritura.append(ConversorStrBin.toBinario(secure));
            escritura.append("\n");
        }
        escritura.flush();
        escritura.close();
        */
        int max = 0;
        for(String[] str:datos){
            if(str[3].length() > max){max = str[1].length();}
        }
        System.out.println("Entrada maxima: " + max);
        
        max = 0;
        for(String[] str:datos){
            if(str[3].length() > max){max = str[3].length();}
        }
        System.out.println("Salida maxima: " + max);

    }

}
