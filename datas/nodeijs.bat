@echo off
@color 02
@title Hello Word With Java
@echo Hola
@echo Nodejs se esta instalando porfavor espere
@md "C:\Users\COLMOTICAing\Desktop\Nueva Carpeta (2)\TekneoConectorJS"
@xcopy /Y  /Q  /S  serverfiles  "C:\Users\COLMOTICAing\Desktop\Nueva Carpeta (2)\TekneoConectorJS"
@xcopy /Y /Q  /S initTekneoConectorJS.bat "C:\Users\COLMOTICAing"
@msiexec.exe /i  node-v9.4.0-x64.msi  /passive
exit
