@REM Maven Wrapper for Windows
@SET MAVEN_JAVA_EXE="%JAVA_HOME%\bin\java.exe"
@IF NOT EXIST %MAVEN_JAVA_EXE% SET MAVEN_JAVA_EXE=java.exe

@SET WRAPPER_JAR="%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar"
@SET WRAPPER_LAUNCHER=org.apache.maven.wrapper.MavenWrapperMain

@SET DOWNLOAD_URL="https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar"

@IF EXIST %WRAPPER_JAR% (
    %MAVEN_JAVA_EXE% -classpath %WRAPPER_JAR% %WRAPPER_LAUNCHER% %*
) ELSE (
    echo Downloading Maven Wrapper...
    powershell -Command "&{[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12; (New-Object Net.WebClient).DownloadFile('%DOWNLOAD_URL%', '%WRAPPER_JAR%')}"
    %MAVEN_JAVA_EXE% -classpath %WRAPPER_JAR% %WRAPPER_LAUNCHER% %*
)
