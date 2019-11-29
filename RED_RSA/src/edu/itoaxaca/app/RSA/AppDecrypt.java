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
public class AppDecrypt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        List<String[]> datos = ManejadorArchivos.leerDatos("D:\\datos.csv");

        RedNeuronal red = new RedNeuronal(2, new int[]{500,500}, 798, 415, 0.7);

        ArrayList<double[]> inputs_training = new ArrayList<>();
        ArrayList<double[]> outputs_training = new ArrayList<>();

        for (String[] array : datos) {
            double[] inputs = ConversorStrBin.toDouble(array[3]);
            double[] outputs = ConversorStrBin.toDouble(array[1]);
            if (inputs.length == 798 && outputs.length == 415) {
                inputs_training.add(inputs);
                outputs_training.add(outputs);
            }
        }

        double err = 0.0;
        int i = 0;

        do {

            red.train(inputs_training.get(i % inputs_training.size()), outputs_training.get(i % inputs_training.size()));

            err = red.calculate_total_error(inputs_training, outputs_training);
            if (i % 1000 == 0) {
                System.err.println(err);
            }
            i++;
        } while (err > 0.005 && i < 50000);

        System.out.format("Error Promedio de : %.4f \n", err);
        File fichero = ManejadorArchivos.crearFichero("D:\\IA\\", "RED_DECRYPT", "obj");
        ManejadorObjetos.writeObj(red, fichero);

    }

}
