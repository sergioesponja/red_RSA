/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itoaxaca.utilities;

import java.math.BigInteger;

/**
 *
 * @author laibr
 */
public class ConversorStrBin {

    public static String toBinario(String text) {
        return new BigInteger(text.getBytes()).toString(2);
    }

    public static String toString(String binary) {
        return new String(new BigInteger(binary, 2).toByteArray());
    }

    public static double[] toDouble(String cadena) {
        double[] datos = new double[cadena.length()];
        try {
            for (int i = 0; i < datos.length; i++) {
                datos[i] = Double.parseDouble(cadena.substring(i,i+1));
            }
        } catch (Exception e) {
            System.err.println("Hubo un error de conversion de string a double...");
        }
        return datos;
    }

    public static double[] generarArrayNumRdm(int valor, int length) {
        if (length > 0) {
            double[] arreglo = new double[length];
            for (int i = 0; i < length; i++) {
                arreglo[i] = valor;
            }
            return arreglo;
        } else {
            return null;
        }
    }
}
