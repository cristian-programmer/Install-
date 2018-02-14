/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execbatch;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author COLMOTICAing
 */
public class Batch {
    
private static final String CMDSTART = " cmd /c start ";
private static final String FILENODEBATCH ="nodeijs.bat";
private static final String FILEDEPENDENCIESJS ="dependenciesjs.bat";
private final String MSINODEJSINSTALL = "./src/nodeInstaller/node-v9.4.0-x64.msi";
private final String ROOT="src\\";
private final String TEKNEOCONECTORJS="TekneoConectorJS"; 
private static final String VBSCODE="./src/execbatch/runHide.vbs";


 public  String  userProfile(){
      String guest_ = System.getenv("USERPROFILE");
         return guest_;
 }   
 

 
 public int  runBatchNodejs(String pathInstallTc) throws FileNotFoundException, IOException, InterruptedException{
    String rootU= userProfile();
    System.out.println("root " + rootU);
        //String rootInitWindows="\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup";
        String rootInitWindows = "\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup";
    
    
        System.out.println("Path: "+pathInstallTc);
         PrintWriter out = new PrintWriter(FILENODEBATCH);
         out.println("@echo off");
         out.println("@color 02");
         out.println("@title Hello Word With Java");
         out.println("@echo Hola");
         out.println("@echo Nodejs se esta instalando porfavor espere");

         //out.println("@xcopy /y  \\nodeInstaller\\node-v9.4.0-x64.msi \""+pathInstallTc+"\\"+ TEKNEOCONECTORJS +"\"");
         out.println("@md \""+pathInstallTc+"\\"+TEKNEOCONECTORJS+"\"");
         out.println("@xcopy /Y  /Q  /S  serverfiles  \""+pathInstallTc +"\\"+ TEKNEOCONECTORJS +"\"");

         out.println("@xcopy /Y /Q  /S initTekneoConectorJS.bat "+ "  \""+rootU+rootInitWindows+"\"");
         out.println("@msiexec.exe /i  node-v9.4.0-x64.msi  /passive");
         System.out.println("path Complete; "+pathInstallTc+"\\"+TEKNEOCONECTORJS+"\\node-v9.4.0-x64.msi");
        // out.println("@\""+rootU+rootInitWindows+"\\initTekneoConectorJS.bat\"");
         System.out.println("@\""+rootU+rootInitWindows+"\\initTekneoConectorJS.bat\"");

         out.println("exit");
         
         out.close();
         
         


         Runtime rt = Runtime.getRuntime();


         Process p = rt.exec(CMDSTART+FILENODEBATCH);
         return  p.waitFor();
         
     }
     public void VbsCode() throws FileNotFoundException, IOException{
         System.out.println("VBSCODE");
         PrintWriter out = new PrintWriter(VBSCODE);
         out.println("Set WSshell =CreateObject(\"WScript.Shell\")");
         out.println("WSshell.Run chr(34) & \"initTekneoConectorJS.bat\" & chr(34), 0");
         out.println(" Set WSshell=Nothing");
         out.close();
         Runtime rt = Runtime.getRuntime();
         Process p = rt.exec(CMDSTART+VBSCODE);
     }
     
     public static void main(String args []){
    try {
        Batch vbs = new Batch();
        vbs.VbsCode();
    } catch (IOException ex) {
        Logger.getLogger(Batch.class.getName()).log(Level.SEVERE, null, ex);
    }
     }
 
}