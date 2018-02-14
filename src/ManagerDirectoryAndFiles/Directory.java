/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerDirectoryAndFiles;

import java.io.File;
import tekneoconector.FunctionsTc;

/**
 *
 * @author COLMOTICAing
 */
public class Directory {
    private  static String NAMEPROJECT ="TekneoConectorJS";
 
    
    public static boolean  searchDirectoryAndFileInstall(String source, boolean other, String otherSource) {
        // la variable source viene con una ruta siempre que se invoque,
        //pero toda ruta debe venir sin \ al final del ultimo nombre del directorio.
        System.out.println("Search... Directory.." + source);
        if(other){
        File f = new File(source);
        String  [] files = f.list();
        for(int i=0; i < files.length; i++){
            String fileexist =files[i];
            System.out.println(fileexist);
            System.out.println("File Exists: " + fileexist);
            
            if(fileexist.equalsIgnoreCase(otherSource)){
                System.out.println("ProgramData:::::"+files[i]);
                File tekCon = new File(source+"\\"+fileexist);
                if(tekCon.isDirectory()){
                    System.out.println("Existe Directorio:" +fileexist);
                    return true;
                }else if(tekCon.isFile()){
                      System.out.println("Existe file:" +fileexist);
                      return true;
                }                
            }else{
               System.out.println("No existe la ruta");
               return false;
            }
        }
        }else if(!other){
              File f = new File(source);
        String  [] files = f.list();
        for(int i=0; i < files.length; i++){
            String fileexist =files[i];
            System.out.println("File Exists: " + fileexist);
            
            if(fileexist.equalsIgnoreCase(NAMEPROJECT)){
                System.out.println("ProgramData:::::"+files[i]);
                File tekCon = new File(source+"\\"+fileexist);
                if(tekCon.isDirectory()){
                    System.out.println("Existe Directorio:" +fileexist);
                    return true;
                }              
            }
        }
            
        }
     
        return false;
      
    }
    
    public static void main(String args[]){
        Directory.searchDirectoryAndFileInstall("C:\\Program Files", true, "nodejs");
    }
}
