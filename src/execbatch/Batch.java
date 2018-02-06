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


 public  String  userProfile(){
      String guest_ = System.getenv("USERPROFILE");
         return guest_;
 }   
 
 public Map<String, String> RootSO(){
     return System.getenv();
 }
 
 public int  runBatchNodejs(String pathInstallTc) throws FileNotFoundException, IOException, InterruptedException{
    System.out.println("PathINstall "+userProfile() + " : "+ RootSO());
     PrintWriter out = new PrintWriter(FILENODEBATCH);
     out.println("@echo off");
     out.println("@color 02");
     out.println("@title Hello Word With Java");
     out.println("@echo Hola");
     out.println("@echo Nodejs se esta instalando porfavor espere");
//     out.println("@msiexec.exe /i "+MSINODEJSINSTALL);
     out.println("@pause");
     out.println("@xcopy /y  src\\nodeInstaller\\node-v9.4.0-x64.msi "+pathInstallTc+"\\"+ TEKNEOCONECTORJS +" ");
     out.println("@xcopy /y  src\\TekneoConectorJS "+pathInstallTc +"\\"+ TEKNEOCONECTORJS +" ");
    
     out.println("@xcopy /y  src\\execbatch\\initTekneoConectorJS.bat "+"  C:\\Users\\COLMOTICAing\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup");
     out.println("@initTekneoConectorJS.bat ");
     out.println("@pause");
   
     out.println("exit");
     out.close();
     
     
     Runtime rt = Runtime.getRuntime();
     
  
     Process p = rt.exec(CMDSTART+FILENODEBATCH);
     return  p.waitFor();
 }
 
 public void runBatchInstallProgram() throws FileNotFoundException, IOException{
     PrintWriter out = new PrintWriter(FILEDEPENDENCIESJS);
     out.println("@echo off");
     out.println("@color 02");
     out.println("@title Second Process");
     out.println("@echo Hola 2");
     
     out.println("exit");
     out.close();
     Runtime rt = Runtime.getRuntime();
     rt.exec(CMDSTART+FILEDEPENDENCIESJS);

  }
  
}