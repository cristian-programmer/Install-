/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execbatch;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author COLMOTICAing
 */
public class Batch {
    
private static final String CMDSTART = " cmd /c start ";
private static final String FILENODEBATCH ="nodeijs.bat";
private static final String FILEDEPENDENCIESJS ="dependenciesjs.bat";
private boolean endfilenodebatch=false;
private boolean endfileinstallProgram=false;

 public  String  userProfile(){
      String guest_ = System.getenv("USERPROFILE");
         return guest_;
 }   
 
 public int  runBatchNodejs() throws FileNotFoundException, IOException, InterruptedException{
    
     PrintWriter out = new PrintWriter(FILENODEBATCH);
     out.println("@echo off");
     out.println("@color 02");
     out.println("@title Hello Word With Java");
     out.println("@echo Hola");
     out.println("@echo Nodejs se esta instalando porfavor espere");
     out.println("@runas /user:COLMOTICAing  msiexec.exe /i  C:\\Users\\COLMOTICAing\\Downloads\\node-v9.4.0-x64.msi /QN /L*V \"C:\\Windows\\Temp\\msilog.log\" ");
     out.println("@echo Hola");
   
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
     this.endfileinstallProgram=true;
 }
 
 public boolean isEndfilenodebatch(){
     
     return this.endfilenodebatch;
 }
 
 public boolean isEndfileinstallProgram(){
     
     return this.endfileinstallProgram;
 }
 
}