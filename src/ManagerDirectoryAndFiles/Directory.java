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
    public static boolean createDirectory(){
        File dir = new File(UtilitariWindows.MyRoots()[0]+"Dirnuew");
        System.out.println(UtilitariWindows.MyRoots()+"Dirnuew".toString());
        if(!dir.exists()){
            dir.mkdir();
            System.out.println("SUCCESSFULL");
        }else{
            System.out.println("BAABB...");
        }
        return true;
    }
    
    public static boolean  searchDirectory(String source){
           char [] m;
           m=source.toCharArray();
       System.out.println("Search directory," +source + "-----------------");
       for(int i=0; i<source.length();i++){
          
           
       }
    return true;
    }
}
