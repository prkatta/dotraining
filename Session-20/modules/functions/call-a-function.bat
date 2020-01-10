@echo off 
SETLOCAL 
CALL :Display 
EXIT /B %ERRORLEVEL% 
:Display 
SET /A index=2 
echo The value of index is %index% 
EXIT /B 0