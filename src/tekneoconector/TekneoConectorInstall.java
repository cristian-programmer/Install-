/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tekneoconector;

import execbatch.Batch;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.processing.Processor;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import nodeInstaller.prueba;


/**
 *
 * @author COLMOTICAing
 */
public class TekneoConectorInstall extends javax.swing.JFrame {
  
    /**
     * Creates new form TekneoConectorSelectRoute
     */
    

    Timer t;
    int i=0;
   
    public TekneoConectorInstall(String source)   {
     
     
   
         ActionListener action = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
           String source ="C:\\Program Files";
           if(ManagerDirectoryAndFiles.Directory.searchDirectoryAndFileInstall(source, true, "nodejs")==false){
                String msg1="instalando archivos porfavor espere.." + i++;
                       msjlbl.setText(msg1);  
                       
                       if(i==1100){
                            if(t.isRunning()){
                  
                            t.stop();
                            msjlbl.setText("Instalacion finalizada");

                            nextbtn.setEnabled(true);
                            nextbtn.setText("Finalizar");
                            }
                       }
                
            }else if(ManagerDirectoryAndFiles.Directory.searchDirectoryAndFileInstall(source, true, "nodejs")==true){
                if(t.isRunning()){
                   t.stop();
                   msjlbl.setText("Instalacion finalizada");
                 
                   nextbtn.setEnabled(true);
                   nextbtn.setText("Finalizar");
                   }
               }
        }
    };
        
        System.out.println("install rote: "+source);
        try {
            
            initComponents();
            FunctionsTc.WindowTekneo(this);
            nextbtn.setEnabled(false);
            
          
            
            execbatch.Batch bathCode = new Batch();
         //compruebo si existe TekneoConectorJS en el source que pasa por defecto o la que toma el cliente.
         //al pasar false,comunica que  no buscara otra carpeta mas que la de la app
         // al pasar "" como no busca otra carpeta diferente solo se agrega para que no busque nada mas.
          if(ManagerDirectoryAndFiles.Directory.searchDirectoryAndFileInstall(source, false, "")){
              
              System.out.println("Ya existe la aplicacion"+ source);
              JOptionPane.showConfirmDialog(null, "Ya existe la aplicacion", "Message", JOptionPane.OK_OPTION);
              System.exit(0);
          }else {
          String routeVbs= System.getProperty("user.home");
          
          System.out.println("instalando espere porfavor....");
          System.out.println();
               bathCode.initTekneoConector(source);
               bathCode.VbsCode(routeVbs);
               bathCode.moveVbsCode();
           int runComplete=bathCode.runBatchNodejs(source, routeVbs);
          
            
               
           if (runComplete==0){
              
               System.out.println("Completado los comandos batch");
               
             String pathNodejs = FunctionsTc.MyRoots() + "\\Program Files";
             t = new Timer(100,action);
             
            t.start();
             
//                 ManagerDirectoryAndFiles.Directory.searchDirectoryAndFileInstall(source, true, "nodejs");
//                      msjlbl.setText("Espere mientra instala los programas necesarios..");
//                
//                if(ManagerDirectoryAndFiles.Directory.searchDirectoryAndFileInstall(pathNodejs, true, "nodejs")){
//                      msjlbl.setText("Se ha instalado Tekneo Conector " + pathNodejs);
////                      msjlbl.setText("Se ha instalado Tekneo Conector");
//               nextbtn.setEnabled(true);
//                }else{
//                        msjlbl.setText("no se encontro nodejs " + pathNodejs);
//                 }
                       
               
           }else{
               
                msjlbl.setText("La instalación ha fallado");
                nextbtn.setText("Finalizar");
           }
             
          }
               
            
        
            
        } catch (IOException ex) {
            
            Logger.getLogger(TekneoConectorInstall.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            
            Logger.getLogger(TekneoConectorInstall.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        nextbtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        msjlbl = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tekneo Conector");

        jLabel2.setText("TODOS LOS DERECHOS RESERVADOS COLMOTICA ING 2018");

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        nextbtn.setText("Siguiente");
        nextbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextbtnActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 562));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("los programas");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Porfavor Espere mientras instala ");

        jLabel4.setText("Luego de terminar la instalacion puede continuar");

        msjlbl.setText("Espere Mientras se Instalan Los programas.... ");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N
        jLabel11.setText("jLabel7");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(msjlbl))
                .addGap(23, 37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(msjlbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 392, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton2)
                    .addComponent(nextbtn)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int data = JOptionPane.showConfirmDialog(null, "¿ Seguro Quieres Salir?", "Alerta",JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);
        System.out.print(data);
        if(data==0){
            System.exit(data);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void nextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbtnActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Debe reiniciar la computadora para que el programa comienze a trabajar");
        System.exit(0);
       
    }//GEN-LAST:event_nextbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        TekneoConectorRouter TcRouterBack = new TekneoConectorRouter();
        setVisible(false);
        TcRouterBack.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private boolean CheckProcessTask(){
        
        try {
                    int contmsi=0;
                    List <String >  procesos = new ArrayList<String>();
                    String line;
                    Process procs = Runtime.getRuntime().exec("tasklist.exe /nh");
                    BufferedReader input = new BufferedReader(new InputStreamReader(procs.getInputStream()));
                    System.out.println("PASEE");
                    while ((line = input.readLine())!=null ){

                        if(!line.trim().equals("")){
                            procesos.add(line.substring(0, line.indexOf(" ")));
                            
                        }
                    }
                    input.close();
                    
                    for(int i=0; i<procesos.size();i++){

                        System.out.println(procesos.get(i));
                        if(procesos.get(i).equals("msiexec.exe")){
                            System.out.println(".......ENCONTRADO...........");
                             contmsi++;
                            
                        }
                    }
                    
                    if(contmsi==1){
                        return true;
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
                }  
        
        return false;
    }
    
    
       private boolean ExistAllFilesNode() {
        int tam_files=0;
          
            String  [] files = {"node.exe","nodevars.bat", "node_etw_provider.man",
                "node_modules", "node_perfctr_provider.man", "npm", "npm.cmd", "npx",
               "npx.cmd"}; 
            String source="C:\\Program Files\\nodejs";
            for(int j=0; j < files.length; j++){
                if(ManagerDirectoryAndFiles.Directory.searchDirectoryAndFileInstall(source, true, files[j])){
                    tam_files++;
                    
                }else{
                        System.out.println("No hay resultados");
                }
                System.out.println(+tam_files+ " : "+ files.length);
                
                if(tam_files==(files.length)){
                    
                    return true;
                }
                
            }
       return false;
   }       
       
       private boolean contentExistFiles(){
           
           try {
              if(ExistAllFilesNode()){
                     return true;
                }else{
                      return false;
                 }
           } catch (Exception e) {
                     return false;
           }
     
       
       }
    /**cdsc
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
            java.util.logging.Logger.getLogger(TekneoConectorInstall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TekneoConectorInstall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TekneoConectorInstall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TekneoConectorInstall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TekneoConectorInstall(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel msjlbl;
    private javax.swing.JButton nextbtn;
    // End of variables declaration//GEN-END:variables
   

}
