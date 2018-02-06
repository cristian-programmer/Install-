/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerDirectoryAndFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author COLMOTICAing
 */
public class Files {
    private static String [] files;
    private static String initSource ="./";
    public static  String [] listFileInstall(){
      
        File fls = new File(initSource);
         files=fls.list();
         for(String string : files){
             System.out.println(string);
         }
        return files;
    }
    
    public static void copyFile(File source, File destination) throws FileNotFoundException, IOException{
    byte[] buffer = new byte[1000000];
    FileInputStream fis = new FileInputStream(source);
    FileOutputStream fos = new FileOutputStream(source);
    
    int reada;
    
    while((reada = fis.read(buffer)) !=-1){
            fos.write(buffer, 0, reada);
    
        }    
        fos.close();
        fis.close();
    }
    public static void main(String args[]){
        File source = new File("C:\\Users\\COLMOTICAing\\Documents\\NetBeansProjects\\TekneoConector\\src\\TekneoConectorJS\\text.txt");
        File destination = new File("C:\\Users\\COLMOTICAing\\Documents\\NetBeansProjects\\TekneoConector\\src\\TekneoConectorJS\\rog.txt");
        
        try {
            System.out.println("Start");
            copyFile(source, 
                    destination);
            System.out.println("Finish");
        } catch (Exception e) {
        }
    }
}
