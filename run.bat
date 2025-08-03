@echo off
REM Define o nome do ficheiro jar do FlatLaf
set FLATLAF_JAR=flatlaf-3.4.jar

REM Compila todos os ficheiros .java listados no sources.txt usando UTF-8 e adiciona o flatlaf no classpath
javac -encoding UTF-8 -cp %FLATLAF_JAR% @sources.txt
if errorlevel 1 (
    echo Erro na compilacao. Verifica os erros e tenta novamente.
    pause
    exit /b 1
)

REM Executa o programa com o flatlaf no classpath
java -cp .;%FLATLAF_JAR% ContadorBlackjackUI

pause
