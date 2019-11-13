@ echo off
md c:\devops\dostestsrc\sub1\sub2 && md c:\devops\dostestbackup
cd c:\devops\dostestsrc
echo "This is a sample text file" > sample.txt
set CURRENT_DATE=%date:~10,4%%date:~4,2%%date:~7,2%
REM md c:\dostestbackup\%CURRENT_DATE%
xcopy c:\devops\dostestsrc\* c:\devops\dostestbackup\%CURRENT_DATE%\* /Y /Q /S /e
EXIT /B
