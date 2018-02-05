/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerDirectoryAndFiles;

import java.io.File;
import tekneoconector.UtilitariWindows;

/**
 *
 * @author COLMOTICAing
 */
public class Directory {
    private static String nameProject ="\\TekneoConectorJS";
    private static String files[]={"configdb, data_os, ejemplo, index, package.json"};
    public static boolean createDirectory(String source){
        System.out.println(source +nameProject);
        File dir = new File(source +nameProject);
        System.out.println(UtilitariWindows.MyRoots()+"Dirnuew".toString());
        if(!dir.exists()){
            dir.mkdir();
            System.out.println("SUCCESSFULL");
        }else{
            System.out.println("BAABB...");
        }
        return true;
    }
    
    public static boolean  searchDirectoryAndFileInstall(String source){

    File f = new File(source);
   if( f.isDirectory() && f.exists()){
       String files[] = f.list();
        for(String file : files){
            System.out.println(file);
            if(file==nameProject ){
                File nameProject = new File(Directory.nameProject);
                if(nameProject.isDirectory()){
                    String filepro [] = nameProject.list();
                    for(int i=0; i<Directory.files.length;i++){
                        if(Directory.files[i]==filepro[i]){
                            return true;
                        }
                    }
                }
            }else {
                return false;
            }
        }
        System.out.println("\n if directory");
   }
    return true;
  }
}
