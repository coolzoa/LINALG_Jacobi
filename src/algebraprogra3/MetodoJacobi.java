/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algebraprogra3;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jack
 */
public class MetodoJacobi extends javax.swing.JFrame {

    /**
     * Creates new form MetodoJacobi
     */
    int n,k,j,h,band,siga,miter;
    double m[][]; 
    double r[]; 
    double x[]; 
    double s[]; 
    double cont[];
    double error[];
    double suma,l,tol;
    Matriz ma;
    public MetodoJacobi() {
        initComponents();
    }
    
    public void llenarMatriz(){
        n=Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de incognitas"));
        try {
            AddMatrizJacobi a = new AddMatrizJacobi(n, n,this);
            a.setVisible(true);
//            ma = new Matriz(n, n);
//            ma = a.llenarMatriz(ma);
//            m = ma.getMatriz();  
            r= new double [n]; 
            s=new double [n];
            x= new double [n];   
        } catch (Exception ex) {
            Logger.getLogger(MetodoJacobi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setMatriz(Matriz pMatriz){
        ma = pMatriz;
        m = ma.getMatriz();
        txtMatriz.setText(ma.toString());
    }
    
    public void cargarSoluciones(){
        for(int i=0;i<=n-1;i++){
            k=i+1;
            r[i]=Double.parseDouble(JOptionPane.showInputDialog("ingrese elelemento "+k+" del vector de soluciones"));
            //x[i]=Double.parseDouble(JOptionPane.showInputDialog("ingrese el valoren el cual quiere comenzar a evaluar x "+k));
            s[i]=0;
        }
        String aux="";
        for (int i = 0; i < r.length; i++) {
            aux += r[i] + "\n";
        }
        txtSoluciones.setText(aux);
    }
    
    public void cargarValores(){
        for(int i=0;i<=n-1;i++){
            k=i+1;
            //r[i]=Double.parseDouble(JOptionPane.showInputDialog("ingrese elelemento "+k+" del vector de soluciones"));
            x[i]=Double.parseDouble(JOptionPane.showInputDialog("ingrese el valoren el cual quiere comenzar a evaluar x "+k));
            s[i]=0;
        }
        String aux="";
        for (int i = 0; i < x.length; i++) {
            aux += r[i] + "\n";
        }
        txtValores.setText(aux);
    }
    
    public void calcular(){    
//        tol=Double.parseDouble(JOptionPane.showInputDialog("ingrese la tolerancia "));
//        miter=Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero maximo de iteraciones"));      
        tol = Double.parseDouble(txtTolerancia.getText());
        miter = Integer.parseInt(txtIteraciones.getText());
        cont= new double [n]; 
        error= new double [n];
//        for(int i=0;i<=n-1;i++){
//            k=i+1;r[i]=Double.parseDouble(JOptionPane.showInputDialog("ingrese elelemento "+k+" del vector de soluciones"));
//            x[i]=Double.parseDouble(JOptionPane.showInputDialog("ingrese el valoren el cual quiere comenzar a evaluar x "+k));
//            s[i]=0;
//            for(j=0;j<=n-1;j++){
//                h=j+1;m[i][j]=Double.parseDouble(JOptionPane.showInputDialog("ingrese elelemento "+k+" "+h+" de la matriz de coeficientes"));
//            }
//        }
        
        
        band=0;
        for(int i=0;i<n;i++){
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
                for(int i=0;i<n;i++){
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
                for(int i=0;i<n;i++){
                    error[i]=Math.abs((s[i]-x[i])/s[i])*100;
                }
                for(int i=0;i<n;i++){
                    x[i]=s[i];
                }
                siga=0;
                for(int i=0;i<n;i++){
                    if(error[i]<tol){
                        siga=siga+1;
                    }
                }
            }
            h=0;
            String result = "";
            for(int i=0;i<n;i++){
                h=h+1;
                result += "x"+h+" es "+s[i]+"\n";
                //JOptionPane.showMessageDialog(null,"el valor aproximado de la incognita x"+h+" es "+s[i]);
            }
            txtResultado.setText(result);
            JOptionPane.showMessageDialog(null,"El numero total de iteraciones fue de "+iter);
        }else{
            JOptionPane.showMessageDialog(null,"No se puede solucionar por estemetodo debido a que la matriz de coeficientes no es diagonalmente dominante");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtMatriz = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        txtTolerancia = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSoluciones = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtValores = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtIteraciones = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtMatriz.setColumns(20);
        txtMatriz.setRows(5);
        jScrollPane1.setViewportView(txtMatriz);

        jButton1.setText("Agregar Matriz");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtSoluciones.setColumns(20);
        txtSoluciones.setRows(5);
        jScrollPane2.setViewportView(txtSoluciones);

        txtValores.setColumns(20);
        txtValores.setRows(5);
        jScrollPane3.setViewportView(txtValores);

        jButton2.setText("Cargar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cargar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane4.setViewportView(txtResultado);

        jLabel1.setText("Tolerancia");

        jLabel2.setText("Iteraciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(116, 116, 116)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTolerancia, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCalcular)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel2)))
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTolerancia, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(3, 3, 3)
                                .addComponent(txtIteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCalcular))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 58, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(80, 80, 80))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        llenarMatriz();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cargarSoluciones();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cargarValores();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        calcular();
    }//GEN-LAST:event_btnCalcularActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MetodoJacobi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MetodoJacobi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MetodoJacobi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MetodoJacobi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MetodoJacobi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField txtIteraciones;
    private javax.swing.JTextArea txtMatriz;
    private javax.swing.JTextArea txtResultado;
    private javax.swing.JTextArea txtSoluciones;
    private javax.swing.JTextField txtTolerancia;
    private javax.swing.JTextArea txtValores;
    // End of variables declaration//GEN-END:variables
}
