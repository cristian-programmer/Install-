/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tekneoconector;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.nio.file.Files;
import javax.swing.JFrame;

/**
 *
 * @author COLMOTICAing
 */
public class FunctionsTc {
    
    
    public static void  WindowTekneo(JFrame windows){
   
        windows.setSize(new Dimension(680, 500));
        Toolkit toolkit = windows.getToolkit();
        Dimension size=  toolkit.getScreenSize();
        windows.setLocation(size.width/2 - windows.getWidth()/2, size.height/2 - windows.getHeight()/2);
        windows.setResizable(false);
    }
    
    
    public static String getRutaSO(){
        String path="";
        path=System.getProperty("user.dir");
        System.out.print(path);
        return path;
    }
    
    public static String MyRoots(){
//        String [] Disk;
 
//        for(int i=0; i < File.listRoots().length;i++){
//            Disk[i]= File.listRoots()[i].getAbsolutePath();     
//        } //        Disk = new String [File.listRoots().length];
// 
//        for(int i=0; i < File.listRoots().length;i++){
//            Disk[i]= File.listRoots()[i].getAbsolutePath();     
//        }     
        return System.getenv("SystemDrive");
    }
    
    public static String getUserSO(){
        String route=getRutaSO();
        char [] Path;
        char [] PathEnd;
        int interalsl=0;
        Path = route.toCharArray();
        char sl='\\';
        
        PathEnd = new char[Path.length];
        for(int i=0; i < Path.length;i++){
          
          PathEnd[i]= Path[i];
          if(Path[i]==sl){
            interalsl++;
            
          }
          
          if(interalsl==4){
              break;
          }
        }    
          String  PathComp = String.valueOf(PathEnd);         
        return PathComp;
    }
}
