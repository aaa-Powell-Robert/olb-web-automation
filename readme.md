# OLB Web Automation

This is a java/TestNG project drives Selenium to verify behavior of OLB.

# Running project

## Setup chromedriver

Copy the `chromedriver.exe` from `G:\ProductAssurance\Selenium POC\SandboxLibraries\chromedriver_win32\chromedriver.exe` to `C:\SandboxLibraries\chromedriver_win32\chromedriver.exe`

Modify the value in `utilities\Constant.Java` as the path to the chrome driver if necessary:

```
...
	public static String ChromeExePath =  "C:\\SandboxLibraries\\chromedriver_win32\\chromedriver.exe";
...
```

## Eclipse

Run as Maven test.

## mvn

On the command line

```
mvn test
```

## Manual Steps - Windows

### Selenium jar

Download `selenium-java-3.11.0.zip` from from https://goo.gl/Us5DnZ and save/extract jar files; for example, uncer `C:\EclipseLibraries\Selenium-3.11.0`:

```
C:\EclipseLibraries\Selenium-3.11.0\client-combined-3.11.0.jar
C:\EclipseLibraries\Selenium-3.11.0\libs\byte-buddy-1.7.9.jar
C:\EclipseLibraries\Selenium-3.11.0\libs\commons-codec-1.10.jar
C:\EclipseLibraries\Selenium-3.11.0\libs\commons-exec-1.3.jar
C:\EclipseLibraries\Selenium-3.11.0\libs\commons-logging-1.2.jar
C:\EclipseLibraries\Selenium-3.11.0\libs\gson-2.8.2.jar
C:\EclipseLibraries\Selenium-3.11.0\libs\guava-23.6-jre.jar
C:\EclipseLibraries\Selenium-3.11.0\libs\httpclient-4.5.3.jar
C:\EclipseLibraries\Selenium-3.11.0\libs\httpcore-4.4.6.jar
C:\EclipseLibraries\Selenium-3.11.0\libs\okhttp-3.9.1.jar
C:\EclipseLibraries\Selenium-3.11.0\libs\okio-1.13.0.jar
```

### TestNG jar

From Eclipse, note the following jars (Eclipse/TestNG plugin):

```
C:\tools\Eclipse_Win32Bit\eclipse\plugins
  org.testng_6.13.1.r201712040515.jar
  com.beust.jcommander_1.72.0.jar
  org.apache-extras.beanshell.bsh_2.0.0.b6.jar
  org.yaml.snakeyaml_1.17.0.jar
```

## Running - Windows

After compiling, use the following to run from command line:

```
java -cp ".;.\bin;C:\EclipseLibraries\Selenium-3.11.0\*;C:\EclipseLibraries\Selenium-3.11.0\libs\*;C:\tools\Eclipse_Win32Bit\eclipse\plugins\*" org.testng.TestNG testng.xml
```

