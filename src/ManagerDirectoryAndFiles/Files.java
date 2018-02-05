/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerDirectoryAndFiles;

import java.io.File;

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
    
    public static void main(String args[]){
        Files.listFileInstall();
    }
}
