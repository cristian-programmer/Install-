/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodeInstaller;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author COLMOTICAing
 */
public class prueba {
    public static void main(String args[]){
        try {
            boolean apro =false;
            int contmsi=0;
            List <String >  procesos = new ArrayList<String>();
            String line;
            Process procs = Runtime.getRuntime().exec("tasklist.exe /nh");
            BufferedReader input = new BufferedReader(new InputStreamReader(procs.getInputStream()));
            System.out.println("PASEE");
            while ((line = input.readLine())!=null ){
        
                if(!line.trim().equals("")){
                    procesos.add(line);
                    
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
        } catch (IOException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
