/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodeInstaller;

/**
 *
 * @author COLMOTICAing
 */
public class Prueba2 {
    private boolean ExistAllFilesNode() {
        int tam_files=0;
          
            String  [] files = {"node.exe","nodevars.bat", "node_etw_provider.man",
                "node_modules", "node_perfctr_provider.man", "npm", "npm.cmd", "npx",
               "npx.cmd"}; 
            String source="C:\\Program Files\\nodejs";
            for(int j=0; j < files.length; j++){
                if(ManagerDirectoryAndFiles.Directory.searchDirectoryAndFileInstall(source, true, files[j])){
                    tam_files++;
                    
                }else{
                        System.out.println("No hay resultados");
                }
                System.out.println(+tam_files+ " : "+ files.length);
                
                if(tam_files==(files.length)){
                    
                    return true;
                }
                
            }
       return false;
   }            

    
    public static void main(String args[]){
       Prueba2 pr = new Prueba2();
     
        try {
            if(  pr.ExistAllFilesNode()){
           System.out.println("TODO OK!!");
       }
        } catch (NullPointerException e) {
            System.out.println("TODO Baddd!!");
            
           
           
            
        }
       
    }
}
