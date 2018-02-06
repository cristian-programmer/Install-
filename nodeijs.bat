@echo off
@color 02
@title Hello Word With Java
@echo Hola
@echo Nodejs se esta instalando porfavor espere
@pause
@xcopy /y  src\nodeInstaller\node-v9.4.0-x64.msi C:\Users\COLMOTICAing\Documents\TekneoConectorJS 
@xcopy /y  src\TekneoConectorJS C:\Users\COLMOTICAing\Documents\TekneoConectorJS 
@xcopy /y  src\execbatch\initTekneoConectorJS.bat   C:\Users\COLMOTICAing\AppData\Roaming\Microsoft\Windows\StartMenu\Programs\Startup
@initTekneoConectorJS.bat 
@pause
exit
