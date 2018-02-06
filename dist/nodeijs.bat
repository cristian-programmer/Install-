@echo off
@color 02
@title Hello Word With Java
@echo Hola
@echo Nodejs se esta instalando porfavor espere
@msiexec.exe /i ./src/nodeInstaller/node-v9.4.0-x64.msi
@pause
@xcopy /y  src\TekneoConectorJS C:\Users\COLMOTICAing\Documents\League of Legends\TekneoConectorJS 
@echo Hola
@pause
exit
