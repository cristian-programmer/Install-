@echo off
@color 02
@title Hello Word With Java
@echo Hola
@echo Nodejs se esta instalando porfavor espere
@pause
@xcopy /Y  /Q  /S  serverfiles  "C:\Users\COLMOTICAing\Documents\PorsiAca\TekneoConectorJS"
@xcopy /Y /Q  /S initTekneoConectorJS.bat   "C:\Users\COLMOTICAing\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Startup"
@msiexec.exe /i  node-v9.4.0-x64.msi  /passive
@pause
exit
