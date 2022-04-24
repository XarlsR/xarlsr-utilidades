/*
Apache License
Version 2.0, January 2004
Copyright [2022] [Carlos R. Puente (XarlsR)]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0
 */

package com.xarlsr.utilidades;

import org.apache.commons.lang3.StringUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 * Devuelve distintos tipos de dato leídos desde teclado<br><br>
 * leeEntero: int<br>
 * leeDoble: double<br>
 * leeCaracter: char<br>
 * leeCadena: String<br>
 * Los datos leídos son comprobados antes de ser devueltos por los métodos.<br><br>
 * Existe un método adicional 'borrarPantalla()' que no devuelve ningún
 * dato, sino que limpia el terminal y coloca el cursor en la primera línea.<br><br>
 * @author XarlsR 2022
 * @version 1.6
 */
public class entradaTeclado {

    static final Scanner scan = new Scanner(System.in);

    /**
     * Devuelve un valor tipo 'string' leído del teclado.<br><br>
     * Ejemplo de uso: String cadena = entradaTeclado.leeCadena();<br><br>
     * @return cadena (String)
     * @since version 1.0
     */
    public static String leeCadena(){
        String cadena = "";
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        try{
            cadena = buff.readLine();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return cadena;
    }

    /**
     * Sobrecarga del método leeCadena que devuelve una cadena de la
     * longitud máxima solicitada, descartando los caracteres que sobrepasen dicha longitud.
     * @param longitud Longitud máxima de la cadena a devolver.
     * @return Cadena (String) de la longitud máxima solicitada.
     */
    public static String leeCadena(int longitud){
        String cadena = "";
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        try{
            cadena = buff.readLine();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if (cadena.length() > longitud) {
            return cadena.substring(0, longitud);
        }
        else return cadena;
    }

    /**
     * Devuelve un número entero introducido por teclado.<br><br>
     * Previamente comprueba que la introducción realizada
     * corresponde a un entero válido.<br><br>
     * Ejemplo de uso: int i = entradaTeclado.leeEntero();<br><br>
     * @return entero (int)
     * @since version 1.0
     */
    public static int leeEntero(){
        int entero = 0;
        boolean esNumero;
        String cadena;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            do {
                cadena = br.readLine();
                esNumero = StringUtils.isNumeric(cadena);
                if (!esNumero) System.out.print("El valor introducido no es un número. Introduzca un número: ");
            }
            while (!esNumero);
            entero = Integer.parseInt(cadena);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return entero;
    }

    /**
     * Devuelve un entero (int) de una longitud máxima determinada por el parámetro 'longitud'.
     * @param longitud Longitud del número a devolver.
     * @return Entero leído.
     * @since version 1.6
     */
    public static int leeEntero(int longitud){
        int entero = 0;
        boolean esNumero;
        String cadena;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            do {
                cadena = br.readLine();
                esNumero = StringUtils.isNumeric(cadena);
                if (!esNumero) System.out.print("El valor introducido no es un número. Introduzca un número: ");
            }
            while (!esNumero);
            if (cadena.length() > longitud){
                cadena = cadena.substring(0, longitud);
            }
            entero = Integer.parseInt(cadena);

        }
        catch (IOException e){
            e.printStackTrace();
        }
        return entero;
    }

    /**
     * Devuelve un carácter (char) introducido por teclado.<br><br>
     * En caso de introducir más de un carácter, devuelve solo el primero.<br><br>
     * Ejemplo de uso: char car = entradaTeclado.leeCaracter;<br><br>
     * @return caracter (char).
     * @since  version 1.2
     */
    public static char leeCaracter(){
        boolean ok = false;
        char caracter = ' ';
        do{
            try{
                caracter = scan.next().charAt(0);
                ok = true;
            }
            catch(Exception e){
                System.out.println("El valor introducido no es un carácter válido");
                System.out.println("Introduzca otro valor correcto tipo 'char' ");
            }
        }
        while (!ok);
        return caracter;
    }

    /**
     * Devuelve un número 'double' leído por teclado.<br><br>
     * Ejemplo de uso: double dbl = entradaTeclado.leeDoble();<br><br>
     * @return doble (double)
     * @since version 1.0
     */
    public static double leeDoble(){
        boolean ok = false;
        double doble = 0.0f;
        do{
            try{
                String  cad = leeCadena();
                doble = Double.parseDouble(cad);
                ok = true;
            }
            catch (Exception e){
                System.out.println("El valor introducido no es un double.");
                System.out.print("Introduzca un double: ");
            }
        }
        while (!ok);
        /*do{                   <---------------------- DEPRECATED SINCE VER. 1.6 ------------------>
            if (scan.hasNextDouble()){
                ok = true;
                doble = scan.nextDouble();
            }
            else{
                System.out.println("El valor introducido no es un double.");
                System.out.print("Introduzca un double: ");
                scan.nextLine();
            }
        }
        while (!ok);            <------------------------------------------------------>*/
        return doble;
    }

    /**
     * Limpia el contenido de la consola<br><br>
     * @since version 1.3
     */
    public static void borrarPantalla(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Pide que se pulse intro para continuar.
     */
    public static void pulseIntro() {
        System.out.print("Pulse INTRO para continuar");
        entradaTeclado.leeCadena();
    }
}
