@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  INFO202 Milestone 1 startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and INF_O202_MILESTONE_1_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\INFO202 Milestone 1.jar;%APP_HOME%\lib\jetty-annotations-10.0.11.jar;%APP_HOME%\lib\jetty-plus-10.0.11.jar;%APP_HOME%\lib\jetty-webapp-10.0.11.jar;%APP_HOME%\lib\apache-jsp-10.0.11.jar;%APP_HOME%\lib\jetty-slf4j-impl-10.0.11.jar;%APP_HOME%\lib\logback-classic-1.2.11.jar;%APP_HOME%\lib\oval-3.2.1.jar;%APP_HOME%\lib\guava-31.1-jre.jar;%APP_HOME%\lib\h2-2.1.214.jar;%APP_HOME%\lib\HikariCP-5.0.1.jar;%APP_HOME%\lib\jdbi3-sqlobject-3.32.0.jar;%APP_HOME%\lib\jdbi3-core-3.32.0.jar;%APP_HOME%\lib\javax.servlet-api-4.0.1.jar;%APP_HOME%\lib\jetty-servlet-10.0.11.jar;%APP_HOME%\lib\jetty-xml-10.0.11.jar;%APP_HOME%\lib\jetty-jndi-10.0.11.jar;%APP_HOME%\lib\jetty-security-10.0.11.jar;%APP_HOME%\lib\jetty-server-10.0.11.jar;%APP_HOME%\lib\jetty-http-10.0.11.jar;%APP_HOME%\lib\jetty-io-10.0.11.jar;%APP_HOME%\lib\jetty-util-10.0.11.jar;%APP_HOME%\lib\slf4j-api-2.0.0-alpha6.jar;%APP_HOME%\lib\jakarta.annotation-api-1.3.5.jar;%APP_HOME%\lib\asm-commons-9.3.jar;%APP_HOME%\lib\asm-analysis-9.3.jar;%APP_HOME%\lib\asm-tree-9.3.jar;%APP_HOME%\lib\asm-9.3.jar;%APP_HOME%\lib\jetty-servlet-api-4.0.6.jar;%APP_HOME%\lib\apache-jsp-9.0.52.jar;%APP_HOME%\lib\logback-core-1.2.11.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\checker-qual-3.12.0.jar;%APP_HOME%\lib\error_prone_annotations-2.11.0.jar;%APP_HOME%\lib\j2objc-annotations-1.3.jar;%APP_HOME%\lib\geantyref-1.3.13.jar;%APP_HOME%\lib\caffeine-3.0.3.jar;%APP_HOME%\lib\jakarta.transaction-api-1.3.3.jar;%APP_HOME%\lib\jetty-schemas-4.0.3.jar;%APP_HOME%\lib\apache-el-9.0.52.jar;%APP_HOME%\lib\ecj-3.26.0.jar


@rem Execute INFO202 Milestone 1
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %INF_O202_MILESTONE_1_OPTS%  -classpath "%CLASSPATH%" JettyServer %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable INF_O202_MILESTONE_1_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%INF_O202_MILESTONE_1_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
