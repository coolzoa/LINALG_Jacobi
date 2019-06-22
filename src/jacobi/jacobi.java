/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jacobi;
import javax.swing.JOptionPane;
public class jacobi {
    
    public void calcular(){
        int n,k,i,j,h,band,siga,miter;
        double m[][]; 
        double r[]; 
        double x[]; 
        double s[]; 
        double cont[];
        double error[];
        double suma,l,tol;
        n=Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero deincognitas"));
        tol=Double.parseDouble(JOptionPane.showInputDialog("ingrese latolerancia "));
        miter=Integer.parseInt(JOptionPane.showInputDialog("ingrese el numeromaximo de iteraciones"));
        m= new double [n][n]; 
        r= new double [n]; 
        x= new double [n]; 
        s=new double [n];
        cont= new double [n]; 
        error= new double [n];
        for(i=0;i<=n-1;i++){
            k=i+1;r[i]=Double.parseDouble(JOptionPane.showInputDialog("ingrese elelemento "+k+" del vector de soluciones"));
            x[i]=Double.parseDouble(JOptionPane.showInputDialog("ingrese el valoren el cual quiere comenzar a evaluar x"+k));
            s[i]=0;
            for(j=0;j<=n-1;j++){
                h=j+1;m[i][j]=Double.parseDouble(JOptionPane.showInputDialog("ingrese elelemento"+k+h+" de la matriz de coeficientes"));
            }
        }
 
        band=0;
        for(i=0;i<n;i++){
            suma=0;
            for(j=0;j<n;j++){
                if(i!=j){
                    suma=suma+m[i][j];
                }
            }
            cont[i]=suma;
            if(Math.abs(m[i][i])>cont[i]){
                band=band+1;
            }
        }
        if(band==n){
            siga=n-1;
            int iter=0;
            while(siga!=n && iter<miter){
                iter=iter+1; 
                for(i=0;i<n;i++){
                    l=0;
                    for(j=0;j<n;j++){
                        if(i==j){
                            l=l+r[i]/m[i][j];
                        }else{
                            l=l-((m[i][j]*x[j])/m[i][i]);
                        }
                    }
                    s[i]=l;
                }
                for(i=0;i<n;i++){
                    error[i]=Math.abs((s[i]-x[i])/s[i])*100;
                }
                for(i=0;i<n;i++){
                    x[i]=s[i];
                }
                siga=0;
                for(i=0;i<n;i++){
                    if(error[i]<tol){
                        siga=siga+1;
                    }
                }
            }
            h=0;
            for(i=0;i<n;i++){
                h=h+1;
                JOptionPane.showMessageDialog(null,"el valor aproximado de la incognitax"+h+" es "+s[i]);
            }
            JOptionPane.showMessageDialog(null,"El numero total de iteraciones fue de"+iter);
        }else{
            JOptionPane.showMessageDialog(null,"No se puede solucionar por estemetodo debido a que la matriz de coeficientes no es diagonalmentedominante");
        }
    }
}
