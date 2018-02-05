@echo off
@color 02
@title Hello Word With Java
@echo Hola
@echo Nodejs se esta instalando porfavor espere
@runas /user:COLMOTICAing  msiexec.exe /i  C:\Users\COLMOTICAing\Downloads\node-v9.4.0-x64.msi /QN /L*V "C:\Windows\Temp\msilog.log" 
@echo Hola
@pause
exit
