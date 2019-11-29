/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itoaxaca.app.RSA;

import edu.itoaxaca.ficheros.manejador.archivos.ManejadorArchivos;
import edu.itoaxaca.ia.red.RedNeuronal;
import edu.itoaxaca.manejador.obj.ManejadorObjetos;
import edu.itoaxaca.utilities.ConversorStrBin;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laibr
 */
public class AppEncrypt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        List<String[]> datos = ManejadorArchivos.leerDatos("D:\\datos.csv");

        RedNeuronal red = new RedNeuronal(2, new int[]{700,1000}, 415, 798, 0.08);
        //RedNeuronal red = (RedNeuronal)ManejadorObjetos.readObj(new File("D:\\IA\\RED_ENCRYPT_500X700-0.08.obj"));
        
        ArrayList<double[]> inputs_training = new ArrayList<>();
        ArrayList<double[]> outputs_training = new ArrayList<>();
        int rows = 0;
        for (String[] array : datos) {
            double[] inputs = ConversorStrBin.toDouble(array[1]);
            double[] outputs = ConversorStrBin.toDouble(array[3]);
            if (inputs.length == 415 && outputs.length == 798) {
                inputs_training.add(inputs);
                outputs_training.add(outputs);
                rows++;
            }
        }
        System.out.println("Sets cargados: " + rows);
        
        double err = 0.0;
        
        /*
        int i = 0;     
        do {
           
            red.train(inputs_training.get(i % inputs_training.size()), outputs_training.get(i % inputs_training.size()));

            err = red.calculate_total_error(inputs_training, outputs_training);
            if (i % 1000 == 0) {
                System.err.println(err);
            }
            i++;
        } while (i < 5000);
        */       
        
        int cont = 0;
        do {
             for(int i = 0;i<inputs_training.size();i++){
                 red.train(inputs_training.get(i), outputs_training.get(i));
             }

            err = red.calculate_total_error(inputs_training, outputs_training);
            if (cont % 1000 == 0) {
                System.err.println(err);
            }
            cont++;
        } while (cont < 20000);
        

        System.out.format("Error Promedio de : %.4f \n", err);
        File fichero = ManejadorArchivos.crearFichero("D:\\IA\\", "RED_ENCRYPT_700X1000-0.08", "obj");
        ManejadorObjetos.writeObj(red, fichero);

    }

}
