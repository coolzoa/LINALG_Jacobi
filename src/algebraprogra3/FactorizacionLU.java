/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algebraprogra3;

/**
 *
 * @author LuisDanielCL
 */

public class FactorizacionLU {
    Matriz matrizL;
    Matriz matrizU;
    Matriz matrizP;
    public FactorizacionLU (){
    }
    public Matriz intercambiarFilasMatriz(Matriz matriz, int i, int j) {
        double temp;      
        double temp2;
        for (int k = 0; k < matriz.largoColumna(); k++) {
            temp = matriz.getElement(i, k);
            temp2 = matrizP.getElement(i, k);
            matriz.setElement(i, k, matriz.getElement(j, k));
            matrizP.setElement(i, k, matrizP.getElement(j, k));
            matriz.setElement(j, k, temp);
            matrizP.setElement(j, k, temp2);
        }
        return matriz;
    }
    
    
    public void factorizar (Matriz pM) throws Exception{
        Matriz m = new Matriz(pM.largoFila(),pM.largoColumna());
        matrizP = new Matriz(pM.largoFila(), pM.largoColumna());
        matrizP.identidad();
        m.copiar(pM);
        Matriz mL = new Matriz(pM.largoFila(),pM.largoColumna());
        mL.identidad();
        boolean error = false;
        int x = 0;
        for (int i=0; i < m.largoFila(); i++){
            if(m.getElement(i, x) == 0){
                intercambiarFilasMatriz(m,0, 2);
            }
            x++;
        }
        if (error){
            throw new Exception("No es factorizable, todos los elementos de su"
                    + "diagonal deben ser diferentes de cero");
        }

         int z= 1;
         for (int d = 0; d<m.largoColumna();d++){
            int p = 0;
            if (m.getElement(d, d)==0){
                p = -1;
                int f = d;
                while ((f< m.largoFila())&& (p ==-1)){
                    if (m.getElement(f, d)!= 0){
                        p=f;
                        intercambiarFilasMatriz(m, d, p);
                        z*= -1;
                    }
                    f+=1;                     
                 }
             }
            double pivote = m.getElement(d, d);
            if (p!=-1){
                for (int f=d+1; f<m.largoFila(); f++){
                    double aux = m.getElement(f, d);
                    mL.setElement(f, d, aux/pivote);
                    for(int c=0; c<m.largoColumna(); c++){
                        m.setElement(f, c, m.getElement(f, c)-
                                (m.getElement(d, c)*(aux/pivote)));
                    }
                }
            }
        }  
        matrizU = m;
        matrizL = mL;
    }
    
    public Matriz getMatrizU(){
        return matrizU;
    }
    
    public Matriz getMatrizL(){
        return matrizL;
    }
    
    public Matriz getMatrizP(){
        return matrizP;
    }
}
