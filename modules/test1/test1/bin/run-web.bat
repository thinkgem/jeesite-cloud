@echo off
rem /**
rem  * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
rem  *
rem  * Author: ThinkGem@163.com
rem  */
echo.
echo [��Ϣ] ���Web���̣�������Web���̡�
echo.

%~d0
cd %~dp0

rem ���Web���̣���ʼ��
cd ..
call mvn clean package spring-boot:repackage -Dmaven.test.skip=true -U
cd target
rem ���Web���̣�������

title %cd%

rem �Ż�JVM����
set "JAVA_OPTS=-Xms512m -Xmx1024m"

rem ��ʽһ�������ⲿ�Զ���������ļ������飩
rem set "JAVA_OPTS=%JAVA_OPTS% -Dspring.config.location=%cd%\app.yml"

rem ��ʽ�������û������ƣ����ز�ͬ�������ļ�
rem set "JAVA_OPTS=%JAVA_OPTS% -Dspring.profiles.active=prod"

if "%JAVA_HOME%" == "" goto noJavaHome
if not "%JAVA_HOME%" == "" goto gotJavaHome
goto end

:noJavaHome
set RUN_JAVA=java
goto runJava

:gotJavaHome
set "RUN_JAVA=%JAVA_HOME%\bin\java"
goto runJava

:runJava
rem ��������޸� web.war Ϊ���� war ������
call "%RUN_JAVA%" %JAVA_OPTS% -jar web.war
goto end

:end
pause