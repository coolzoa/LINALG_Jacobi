/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algebraprogra3;

import javax.swing.JOptionPane;

/**
 *
 * @author josemurillo
 */
public class MatrizPa {
    Matriz matrizL;
    Matriz matrizU;
    Matriz matrizP;
    Matriz p;
    double[][] respuestas;
    
    void calcularP(Matriz pmatrizA){
        FactorizacionLU flu = new FactorizacionLU();
        try{
        flu.factorizar(pmatrizA);
        matrizL = flu.getMatrizL();
        matrizU = flu.getMatrizU();
        matrizP = flu.getMatrizP();
               
        
    }catch (Exception e){
       JOptionPane.showMessageDialog(null, "La matriz P no se pudo calcular");
    }

    }
    
}
